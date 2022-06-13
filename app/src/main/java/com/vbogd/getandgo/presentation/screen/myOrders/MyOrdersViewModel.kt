package com.vbogd.getandgo.presentation.screen.myOrders

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vbogd.getandgo.data.OrderService
import com.vbogd.getandgo.domain.model.Order
import com.vbogd.getandgo.domain.model.OrderStatus

class MyOrdersViewModel : ViewModel() {

    private val repository = OrderService()

    private val _orders = MutableLiveData<List<Order>>()
    val orders: LiveData<List<Order>> = _orders

    private val _ordersCount = MutableLiveData<Int>()
    val ordersCount: LiveData<Int> = _ordersCount

    private val _navigateToOrderDetails = MutableLiveData<Order?>()
    val navigateToOrderDetails: LiveData<Order?> = _navigateToOrderDetails

    init {
        _orders.value = repository.getOrdersByStatus(OrderStatus.RESERVED)
        Log.d("TAG", _orders.value.toString())
//        getOrdersByStatus(OrderStatus.RESERVED)
    }

    fun getOrdersByStatus(orderStatus: OrderStatus) {
        repository.getOrdersByStatus(orderStatus).let { orderList ->
            _orders.value = orderList
            _ordersCount.value = orderList.size
        }
    }

    fun displayOrderDetails(order: Order) {
        _navigateToOrderDetails.value = order
    }

    fun displayOrderDetailsComplete() {
        _navigateToOrderDetails.value = null
    }

}