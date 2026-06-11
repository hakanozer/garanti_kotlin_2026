package com.works.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToMany

@Entity
data class Customer(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var cid: Long? = null,

    @Column(nullable = false, length = 100)
    var name: String? = null,

    @Column(nullable = false, length = 100)
    var surname: String? = null,

    @Column(nullable = false, length = 150, unique = true)
    var email: String? = null,

    @Column(nullable = false)
    var password: String? = null,

    @ManyToMany
    var roles: MutableList<Role>? = null
)