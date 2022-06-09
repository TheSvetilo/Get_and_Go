package com.vbogd.getandgo.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Address(
    val id: Int,
    val city: String,
    val street: String,
    val homeNumber: String,
    val floor: Int,
    val flatNumber: Int,
    val longitude: String,
    val latitude: String
): Parcelable {
    override fun toString(): String {
        return "$street, дом $homeNumber, этаж $floor, кв. $flatNumber"
    }
}