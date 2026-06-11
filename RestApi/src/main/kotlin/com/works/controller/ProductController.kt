package com.works.controller

import com.works.entity.Product
import com.works.service.ProductService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/product")
class ProductController(
    private val productService: ProductService
) {

    @PostMapping("save")
    fun save(@RequestBody product: Product) = productService.save(
        product
    )

    @GetMapping("list")
    fun list() = productService.list()

}