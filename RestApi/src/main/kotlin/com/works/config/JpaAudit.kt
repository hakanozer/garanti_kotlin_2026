package com.works.config

import org.springframework.context.annotation.Configuration
import org.springframework.data.domain.AuditorAware
import org.springframework.security.core.context.SecurityContextHolder
import java.util.Optional

@Configuration
class JpaAudit : AuditorAware<String> {

    override fun getCurrentAuditor(): Optional<String> {
        val auth = SecurityContextHolder.getContext().authentication
        return Optional.ofNullable(auth?.name)
    }

}