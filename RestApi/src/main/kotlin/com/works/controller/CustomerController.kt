package com.works.controller

import com.works.dto.CustomerCreateDto
import com.works.entity.Customer
import com.works.service.CustomerService
import jakarta.validation.Valid
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/customers")
class CustomerController(
    private val customerService: CustomerService
) {

    @PostMapping("register")
    fun register(@Valid @RequestBody customerCreateDto: CustomerCreateDto) : Customer {
        return customerService.register(customerCreateDto)
    }

}