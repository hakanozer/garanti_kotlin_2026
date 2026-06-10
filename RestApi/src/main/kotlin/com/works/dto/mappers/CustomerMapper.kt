package com.works.dto.mappers

import com.works.dto.CustomerCreateDto
import com.works.entity.Customer
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface CustomerMapper {

    fun customerCreateDtoToCustomer(customerCreateDto: CustomerCreateDto): Customer

}