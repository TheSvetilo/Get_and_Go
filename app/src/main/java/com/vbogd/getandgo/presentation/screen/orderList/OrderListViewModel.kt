package com.vbogd.getandgo.presentation.screen.orderList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vbogd.getandgo.domain.OrderRepository
import com.vbogd.getandgo.domain.model.Order
import com.vbogd.getandgo.domain.model.OrderStatus
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class OrderListViewModel @Inject constructor(
    private val repository: OrderRepository
) : ViewModel() {

    private val _orders = MutableLiveData<List<Order>>()
    val orders: LiveData<List<Order>> = _orders

    private val _order = MutableLiveData<Order>()
    val order: LiveData<Order> = _order

    private val _navigateToOrderDetails = MutableLiveData<Order?>()
    val navigateToOrderDetails: LiveData<Order?> = _navigateToOrderDetails

    init {
        getOrdersForBooking()
    }

    private fun getOrdersForBooking() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getOrdersByStatus(OrderStatus.BOOKING_READY).let {
                withContext(Dispatchers.Main) {
                    _orders.value = it
                }
            }
        }
    }

    fun displayOrderDetails(order: Order) {
        _navigateToOrderDetails.value = order
    }

    fun displayOrderDetailsComplete() {
        _navigateToOrderDetails.value = null
    }

}