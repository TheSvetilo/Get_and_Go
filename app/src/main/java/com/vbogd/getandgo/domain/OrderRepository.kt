package com.vbogd.getandgo.domain

import com.vbogd.getandgo.domain.model.Order
import com.vbogd.getandgo.domain.model.OrderStatus

interface OrderRepository {

    fun getOrders(): List<Order>
    fun getOrder(id: Int): Order
    fun getOrdersByStatus(status: OrderStatus): List<Order>

}