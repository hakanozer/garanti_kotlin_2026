package com.works.dto

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import java.io.Serializable

/**
 * DTO for {@link com.works.entity.Customer}
 */
data class CustomerCreateDto(
    @field:NotNull @field:Size(min = 2, max = 100) @field:NotEmpty val name: String? = null,
    @field:NotNull @field:Size(min = 2, max = 100) @field:NotEmpty val surname: String? = null,
    @field:NotNull @field:Size(min = 6, max = 100) @field:Email @field:NotEmpty val email: String? = null,
    @field:NotNull @field:Size(min = 5, max = 15) @field:NotEmpty val password: String? = null
)