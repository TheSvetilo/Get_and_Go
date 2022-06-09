package com.vbogd.getandgo.presentation.screen.orderDetails

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.vbogd.getandgo.domain.model.Order
import java.lang.IllegalArgumentException

class OrderDetailsViewModelFactory(
    private val order: Order
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(OrderDetailsViewModel::class.java)) {
            return OrderDetailsViewModel(order) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}