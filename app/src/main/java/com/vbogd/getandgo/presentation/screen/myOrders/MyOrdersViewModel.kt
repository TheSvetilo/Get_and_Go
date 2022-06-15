package com.vbogd.getandgo.presentation.screen.myOrders

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
class MyOrdersViewModel @Inject constructor(
    private val repository: OrderRepository
) : ViewModel() {

    private val _orders = MutableLiveData<List<Order>>()
    val orders: LiveData<List<Order>> = _orders

    private val _ordersCount = MutableLiveData<Int>()
    val ordersCount: LiveData<Int> = _ordersCount

    private val _orderTab = MutableLiveData<Int>()
    val orderTab: LiveData<Int> = _orderTab

    private val _navigateToOrderDetails = MutableLiveData<Order?>()
    val navigateToOrderDetails: LiveData<Order?> = _navigateToOrderDetails

    init {
        getMyOrders(OrderStatus.RESERVED)
    }

    fun getMyOrders(status: OrderStatus) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getOrdersByStatus(status).let {
                withContext(Dispatchers.Main) {
                    _orders.value = it
                    _ordersCount.value = it?.size
                }
            }
        }
    }

    fun saveTabState(tabId: Int) {
        _orderTab.value = tabId
    }

    fun displayOrderDetails(order: Order) {
        _navigateToOrderDetails.value = order
    }

    fun displayOrderDetailsComplete() {
        _navigateToOrderDetails.value = null
    }

}