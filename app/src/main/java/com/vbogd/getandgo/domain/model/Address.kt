package com.vbogd.getandgo.domain.model

data class Address(
    val id: Int,
    val city: String,
    val street: String,
    val homeNumber: String,
    val floor: Int,
    val flatNumber: Int
)
