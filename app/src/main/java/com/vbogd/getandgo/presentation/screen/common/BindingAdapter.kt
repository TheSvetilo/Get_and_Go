package com.vbogd.getandgo.presentation.screen.common

import android.widget.Button
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.vbogd.getandgo.R
import com.vbogd.getandgo.domain.model.Order
import com.vbogd.getandgo.domain.model.OrderStatus
import com.vbogd.getandgo.presentation.screen.orderList.OrderListAdapter

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<Order>?) {
    val adapter = recyclerView.adapter as OrderListAdapter
    adapter.submitList(data)
}

@BindingAdapter("price")
fun bindPrice(text: TextView, price: Double) {
    text.text = "$price руб."
}

@BindingAdapter("weight")
fun bindWeight(text: TextView, weight: Double) {
    text.text = "$weight кг"
}

@BindingAdapter("orderSize")
fun bindSize(text: TextView, order: Order) {
    text.text = "${order.width} x ${order.height} x ${order.width} м"
}

@BindingAdapter("orderDeliveryTime")
fun bindDeliveryTime(text: TextView, order: Order) {
    text.text = "${order.deliveryTimeFrom} - ${order.deliveryTimeTo}"
}

@BindingAdapter("orderStatus")
fun bindButtonText(btn: Button, status: OrderStatus) {
    when (status) {
        OrderStatus.BOOKING_READY -> btn.text = "Выехал за грузом"
    }
}