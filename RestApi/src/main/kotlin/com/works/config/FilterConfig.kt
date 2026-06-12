package com.works.config

import jakarta.servlet.Filter
import jakarta.servlet.FilterChain
import jakarta.servlet.ServletRequest
import jakarta.servlet.ServletResponse
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.slf4j.LoggerFactory.getLogger
import org.springframework.context.annotation.Configuration
import org.springframework.security.core.context.SecurityContextHolder

@Configuration
class FilterConfig : Filter {

    // logger obj
    private val logger = getLogger(FilterConfig::class.java)

    override fun doFilter(
        p0: ServletRequest?,
        p1: ServletResponse?,
        p2: FilterChain?
    ) {

        val req = p0 as HttpServletRequest
        val res = p1 as HttpServletResponse

        val start = System.currentTimeMillis()

        val auth = SecurityContextHolder.getContext().authentication

        val username = auth?.name ?: "ANONYMOUS"

        // header add item
        res.setHeader("token", "tokenUser")

        p2?.doFilter(req, res)

        val duration = System.currentTimeMillis() - start

        logger.info(
            "USER={} METHOD={} URI={} STATUS={} IP={} AGENT=\"{}\" LOCALE={} DURATION={}ms",
            username,
            req.method,
            req.requestURI,
            res.status,
            req.remoteAddr,
            req.getHeader("User-Agent"),
            req.locale,
            duration
        )
    }


}