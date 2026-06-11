package com.works.service

import com.works.entity.Product
import com.works.repository.ProductRepository
import org.springframework.stereotype.Service

@Service
class ProductService(
    private val productRepository: ProductRepository
) {

    // save
    fun save(product: Product) : Product {
        return productRepository.save(product)
    }

    // list
    fun list() = productRepository.findAll()
}