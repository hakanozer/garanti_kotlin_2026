package com.works.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class Note : BaseEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    open var nid: Long? = null

    open var name: String? = null

    var description: String? = null

}

