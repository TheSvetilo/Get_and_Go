package com.vbogd.getandgo.domain.model

data class Order(
    // Base
    val id: Int,
    val number: String,
    val status: String,
    val shortDescription: String,
    val comment: String,
    val price: Long,

    // Size Options
    val weight: Long,

    // Delivery Options
    val addressFrom: Address,
    val addressTo: Address,
    val deliveryDate: String,
    val deliveryTimeFrom: String,
    val deliveryTimeTo: String,
    val contactPerson: String,
)
