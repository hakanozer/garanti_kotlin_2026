package com.works.config

import com.works.service.CustomerService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.dao.DaoAuthenticationProvider
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain

@Configuration
class SecurityConfig {

    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        return http
            .httpBasic { }
            .csrf { it.disable() }
            .authorizeHttpRequests {
                it.requestMatchers("/api/v1/product/**").hasRole("product")
                it.requestMatchers("/api/v1/note/**").hasRole("note")
                it.requestMatchers("/api/v1/customer/**").permitAll()
                it.anyRequest().authenticated()
            }
            .build()
    }

    // customerService ve passwordEncoder spring securty kullanımı için provider yapılıyor.
    @Bean
    fun authenticationProvider(
        customerService: CustomerService,
        passwordEncoder: PasswordEncoder
    ): DaoAuthenticationProvider {
        val provider = DaoAuthenticationProvider(customerService)
        provider.setPasswordEncoder(passwordEncoder)
        return provider
    }

}

/*
ali@mail.com -> product
ahmet@mail.com -> note
zehra@mail.com -> product, note
 */