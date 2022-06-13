package com.vbogd.getandgo.presentation.screen.orderList.orderMap

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vbogd.getandgo.data.OrderService
import com.vbogd.getandgo.domain.model.Order
import com.vbogd.getandgo.domain.model.OrderStatus

class OrderMapViewModel : ViewModel() {

    private val _orders = MutableLiveData<List<Order>>()
    val orders: LiveData<List<Order>> = _orders

    private val _navigateToOrderDetails = MutableLiveData<Order?>()
    val navigateToOrderDetails: LiveData<Order?> = _navigateToOrderDetails

    private val repository = OrderService()

    init {
        _orders.value = repository.getOrdersByStatus(OrderStatus.BOOKING_READY)
    }

    fun displayOrderDetails(order: Order) {
        _navigateToOrderDetails.value = order
    }

    fun displayOrderDetailsComplete() {
        _navigateToOrderDetails.value = null
    }

}