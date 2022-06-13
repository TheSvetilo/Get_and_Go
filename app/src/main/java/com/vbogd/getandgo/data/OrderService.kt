package com.vbogd.getandgo.data

import com.vbogd.getandgo.domain.OrderRepository
import com.vbogd.getandgo.domain.model.Order
import com.vbogd.getandgo.domain.model.OrderStatus

class OrderService : OrderRepository {

    private val orders = OrderData().orders

    override fun getOrders(): List<Order> {
        return orders
    }

    override fun getOrder(id: Int): Order? {
        return orders.findLast { it.id == id }
    }

    override fun getOrdersByStatus(status: OrderStatus): List<Order> {
        return orders.filter { it.status == status }
    }

}