package com.works.service

import com.works.entity.Product
import com.works.repository.ProductRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.Cacheable
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Service

@Service
class ProductService(
    private val productRepository: ProductRepository,
    private val invoiceService: InvoiceService
) {

    // save
    @CacheEvict(cacheNames = ["products"], allEntries = true)
    fun save(product: Product) : Product {
        return productRepository.save(product)
    }

    // list
    @Cacheable(cacheNames = ["products"])
    suspend fun list() : List<Product> {
        val products = productRepository.findAll()
        invoiceService.asyncGenerateInvoice(10)
        println("This line Call")
        val path = generateInvoice(10)
        println("PDF: $path")
        return products
    }

    suspend fun generateInvoice(orderId: Long): String =
        withContext(Dispatchers.IO) {
            delay(3000)
            "pdfFile_pdf"
        }


}