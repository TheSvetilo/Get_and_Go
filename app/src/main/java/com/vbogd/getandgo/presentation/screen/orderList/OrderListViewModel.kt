package com.vbogd.getandgo.presentation.screen.orderList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vbogd.getandgo.data.OrderService
import com.vbogd.getandgo.domain.model.Order

class OrderListViewModel : ViewModel() {

    private val repository = OrderService()

    private val _orders = MutableLiveData<List<Order>>()
    val orders: LiveData<List<Order>> = _orders

    init {
        _orders.value = repository.getOrders()
    }

}