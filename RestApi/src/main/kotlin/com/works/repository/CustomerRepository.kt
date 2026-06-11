package com.works.repository

import com.works.entity.Customer
import org.springframework.data.jpa.repository.JpaRepository

interface CustomerRepository : JpaRepository<Customer, Long> {

    fun findByEmailEqualsIgnoreCase(email: String): Customer?

}