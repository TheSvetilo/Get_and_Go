package com.vbogd.getandgo.presentation.screen.orderList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.vbogd.getandgo.databinding.OrderItemBinding
import com.vbogd.getandgo.domain.model.Order

class OrderListAdapter(private val clickListener: OnClickListener) :
    ListAdapter<Order, OrderListAdapter.OrderViewHolder>(DiffCallback()) {

    class OrderViewHolder(private val binding: OrderItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(order: Order) {
            binding.order = order
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewHolder {
        return OrderViewHolder(
            OrderItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: OrderViewHolder, position: Int) {
        val order = getItem(position)
        holder.itemView.setOnClickListener {
            clickListener.onClick(order)
        }
        holder.bind(order)
    }
}

class DiffCallback : DiffUtil.ItemCallback<Order>() {
    override fun areItemsTheSame(oldItem: Order, newItem: Order): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Order, newItem: Order): Boolean {
        return oldItem.id == newItem.id
    }
}

class OnClickListener(val clickListener: (order: Order) -> Unit) {
    fun onClick(order: Order) = clickListener(order)
}