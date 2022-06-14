package com.vbogd.getandgo.presentation.screen.orderDetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vbogd.getandgo.domain.model.Order


class OrderDetailsViewModel(
    order: Order
) : ViewModel() {

    private val _selectedOrder = MutableLiveData<Order>()
    val selectedOrder: LiveData<Order> = _selectedOrder

    init {
        _selectedOrder.value = order
    }

}