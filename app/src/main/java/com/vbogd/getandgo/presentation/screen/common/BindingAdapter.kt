package com.vbogd.getandgo.presentation.screen.common

import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.vbogd.getandgo.R
import com.vbogd.getandgo.domain.model.Order
import com.vbogd.getandgo.presentation.screen.orderList.OrderListAdapter

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<Order>?) {
    val adapter = recyclerView.adapter as OrderListAdapter
    adapter.submitList(data)
}

@BindingAdapter("price")
fun bindPrice(text: TextView, price: Double) {
    text.text = "$price"
}

@BindingAdapter("weight")
fun bindWeight(text: TextView, weight: Long) {
    text.text = weight.toString()
}