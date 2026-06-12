package com.works.entity

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.EntityListeners
import jakarta.persistence.MappedSuperclass
import org.springframework.data.annotation.CreatedBy
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedBy
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime

@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
class BaseEntity {

    @JsonIgnore
    @CreatedDate
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    var createdDate: LocalDateTime? = null

    @JsonIgnore
    @LastModifiedDate
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    var lastModifiedDate: LocalDateTime? = null

    @JsonIgnore
    @CreatedBy
    var createdBy: String? = null

    @JsonIgnore
    @LastModifiedBy
    var lastModifiedBy: String? = null

}