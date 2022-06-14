package com.vbogd.getandgo.data.local

import com.vbogd.getandgo.domain.model.Order
import com.vbogd.getandgo.domain.model.OrderStatus

interface OrderLocalDataSource {

    suspend fun getOrder(id: Int): Order?
    suspend fun getOrdersByStatus(status: OrderStatus): List<Order>

}