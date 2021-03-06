package com.cberry.springsite.model

import javax.persistence.*

//"CREATE TABLE PERSON(ID INT PRIMARY KEY, NAME VARCHAR(255));"

@Entity
data class Person @JvmOverloads constructor(
        @[Id GeneratedValue(strategy = GenerationType.IDENTITY)] val id: Int,
        @Column(nullable = false)                                val name: String,
        @Column(nullable = true)                                 val email: String? = null,
        @OneToMany(cascade = [CascadeType.ALL])                  val phoneNumbers: List<PhoneNumber>? = null
)

@Entity
data class PhoneNumber(
        @[Id GeneratedValue(strategy = GenerationType.IDENTITY)] val id: Int,
        @Column(nullable = false)                                val number: String
)