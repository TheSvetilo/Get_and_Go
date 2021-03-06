package com.vbogd.getandgo.domain

import com.vbogd.getandgo.domain.model.Order
import com.vbogd.getandgo.domain.model.OrderStatus

interface OrderRepository {

    suspend fun getOrder(id: Int): Order?
    suspend fun getOrdersByStatus(status: OrderStatus): List<Order>?

}