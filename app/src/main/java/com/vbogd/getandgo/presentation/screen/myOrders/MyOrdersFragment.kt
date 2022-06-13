package com.vbogd.getandgo.presentation.screen.myOrders

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.google.android.material.tabs.TabLayout
import com.vbogd.getandgo.R
import com.vbogd.getandgo.databinding.FragmentMyOrderBinding
import com.vbogd.getandgo.presentation.screen.orderList.OnClickListener
import com.vbogd.getandgo.presentation.screen.orderList.OrderListAdapter

class MyOrdersFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val viewModel: MyOrdersViewModel = ViewModelProvider(this).get(MyOrdersViewModel::class.java)

        val binding = FragmentMyOrderBinding.inflate(inflater)

        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel

        binding.recyclerViewMyOrders.adapter = OrderListAdapter(OnClickListener {
            viewModel.displayOrderDetails(it)
            Log.d("TAG", it.toString())
        })

        viewModel.navigateToOrderDetails.observe(viewLifecycleOwner) { orderDetailsId ->
            if (orderDetailsId != null) {
                this.findNavController()
                    .navigate(MyOrdersFragmentDirections.actionShowDetails(orderDetailsId))
                viewModel.displayOrderDetailsComplete()
            }
        }

        return binding.root
    }

}