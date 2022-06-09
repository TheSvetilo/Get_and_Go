package com.vbogd.getandgo.presentation.screen.orderList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.vbogd.getandgo.R
import com.vbogd.getandgo.databinding.FragmentOrderListBinding

class OrderListFragment : Fragment() {

    private val viewModel: OrderListViewModel by lazy {
        ViewModelProvider(this).get(OrderListViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentOrderListBinding.inflate(inflater)

        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.recyclerView.adapter = OrderListAdapter(OnClickListener {
            viewModel.displayOrderDetails(it)
        })

        viewModel.navigateToOrderDetails.observe(viewLifecycleOwner) { orderId ->
            if (orderId != null) {
                this.findNavController().navigate(OrderListFragmentDirections.actionShowDetails(orderId))
                viewModel.displayOrderDetailsComplete()
            }
        }

        return binding.root
    }
}