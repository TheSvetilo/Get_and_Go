package com.vbogd.getandgo.presentation.screen.myOrders

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.google.android.material.tabs.TabLayout
import com.vbogd.getandgo.R
import com.vbogd.getandgo.databinding.FragmentMyOrderBinding
import com.vbogd.getandgo.domain.model.OrderStatus
import com.vbogd.getandgo.presentation.screen.orderList.OnClickListener
import com.vbogd.getandgo.presentation.screen.orderList.OrderListAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MyOrdersFragment : Fragment() {

    val viewModel: MyOrdersViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentMyOrderBinding.inflate(inflater)

        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel

        binding.recyclerViewMyOrders.adapter = OrderListAdapter(OnClickListener {
            viewModel.displayOrderDetails(it)
            Log.d("TAG", it.toString())
        })

        viewModel.orderTab.observe(viewLifecycleOwner) {
            binding.tabLayout.getTabAt(it)!!.select()
        }

        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                val tabId = tab!!.position
                when (tabId) {
                    0 -> viewModel.getMyOrders(OrderStatus.RESERVED)
                    1 -> viewModel.getMyOrders(OrderStatus.DELIVERY)
                }
                viewModel.saveTabState(tabId)
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {}

            override fun onTabReselected(tab: TabLayout.Tab?) {
                when (tab?.position) {
                    0 -> viewModel.getMyOrders(OrderStatus.RESERVED)
                    1 -> viewModel.getMyOrders(OrderStatus.DELIVERY)
                }
            }
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