package com.works.service

import com.works.dto.CustomerCreateDto
import com.works.dto.mappers.CustomerMapper
import com.works.entity.Customer
import com.works.repository.CustomerRepository
import org.springframework.stereotype.Service

@Service
class CustomerService(
    private val customerRepository: CustomerRepository,
    private val customerMapper: CustomerMapper
) {

    fun register(customerCreateDto: CustomerCreateDto) : Customer {
        val dbCustomer = customerRepository.findByEmailEqualsIgnoreCase(customerCreateDto.email!!)
        dbCustomer?.let { throw IllegalStateException("Email already exists: ${customerCreateDto.email}") }
        val customer = customerMapper.customerCreateDtoToCustomer(customerCreateDto)
        customerRepository.save(customer)
        return customer
    }


}