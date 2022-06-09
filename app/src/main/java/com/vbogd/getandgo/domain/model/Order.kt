package com.vbogd.getandgo.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Order(
    // Base
    val id: Int,
    val number: String,
    val status: OrderStatus,
    val shortDescription: String,
    val comment: String,
    val price: Double,

    // Size Options
    val weight: Double,
    val height: Double,
    val width: Double,
    val length: Double,

    // Delivery Options
    val addressFrom: Address,
//    val addressFrom: String,
    val addressTo: Address,
//    val addressTo: String,
    val deliveryDate: String,
    val deliveryTimeFrom: String,
    val deliveryTimeTo: String,
    val contactPerson: String,
) : Parcelable
