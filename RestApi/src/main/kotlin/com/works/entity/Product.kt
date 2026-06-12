package com.works.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.io.Serializable

@Entity
class Product : Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    open var pid: Long? = null

    open var name: String? = null

    var price: Double? = null
}