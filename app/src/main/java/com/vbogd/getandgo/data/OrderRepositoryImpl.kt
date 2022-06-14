package com.vbogd.getandgo.data

import com.vbogd.getandgo.data.local.OrderLocalDataSource
import com.vbogd.getandgo.domain.OrderRepository
import com.vbogd.getandgo.domain.model.Order
import com.vbogd.getandgo.domain.model.OrderStatus
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class OrderRepositoryImpl @Inject constructor(
    private val orderSource: OrderLocalDataSource
) : OrderRepository {

    override suspend fun getOrder(id: Int): Order? {
        return orderSource.getOrder(id)
    }

    override suspend fun getOrdersByStatus(status: OrderStatus): List<Order> {
        return orderSource.getOrdersByStatus(status)
    }

}