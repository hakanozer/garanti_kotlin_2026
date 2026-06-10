package com.works.controller

import com.works.dto.CustomerCreateDto
import com.works.dto.mappers.CustomerMapper
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/customers")
class CustomerController( private val customerMapper: CustomerMapper ) {

    @PostMapping("register")
    fun register(@RequestBody customerCreateDto: CustomerCreateDto) {
        val customer = customerMapper.customerCreateDtoToCustomer(customerCreateDto)
        println("Received customer registration: $customerCreateDto")
        println("Mapped customer entity: $customer")
    }

}