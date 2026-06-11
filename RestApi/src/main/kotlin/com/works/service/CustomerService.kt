package com.works.service

import com.works.dto.CustomerCreateDto
import com.works.dto.mappers.CustomerMapper
import com.works.entity.Customer
import com.works.repository.CustomerRepository
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class CustomerService(
    private val customerRepository: CustomerRepository,
    private val customerMapper: CustomerMapper,
    private val passwordEncoder: PasswordEncoder
) : UserDetailsService {

    fun register(customerCreateDto: CustomerCreateDto) : Customer {
        val dbCustomer = customerRepository.findByEmailEqualsIgnoreCase(customerCreateDto.email!!)
        dbCustomer?.let { throw IllegalStateException("Email already exists: ${customerCreateDto.email}") }
        val customer = customerMapper.customerCreateDtoToCustomer(customerCreateDto)
        customer.roles = customerCreateDto.roles
        customer.password = passwordEncoder.encode(customerCreateDto.password!!)
        customerRepository.save(customer)
        return customer
    }

    override fun loadUserByUsername(username: String): UserDetails {
        val dbCustomer = customerRepository.findByEmailEqualsIgnoreCase(username)
        if (dbCustomer == null) throw UsernameNotFoundException("Customer not found with email: $username")
        return User(
            dbCustomer.email!!,
            dbCustomer.password!!,
            dbCustomer.roles!!.map { SimpleGrantedAuthority(it.name!!) }
        )
    }


}