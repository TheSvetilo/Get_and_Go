package com.vbogd.getandgo.presentation.screen.orderList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.vbogd.getandgo.databinding.OrderItemBinding

class OrdeItemList : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = OrderItemBinding.inflate(inflater)

        val viewModel = ViewModelProvider(this).get(OrderListViewModel::class.java)

        viewModel.order.observe(viewLifecycleOwner) {
            binding.order = it
        }

        return binding.root
    }

}