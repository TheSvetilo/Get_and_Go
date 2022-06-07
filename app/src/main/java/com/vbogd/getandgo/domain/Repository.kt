package com.vbogd.getandgo.domain

import com.vbogd.getandgo.domain.model.Order

interface Repository {

    fun getOrders(): List<Order>
    fun getOrder(id: Int): Order
    fun getOrdersByStatus(): List<Order>

}