package com.vbogd.getandgo.presentation.screen.orderDetails

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.vbogd.getandgo.databinding.FragmentOrderDetailsBinding
import com.yandex.mapkit.Animation
import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.map.CameraPosition
import com.yandex.mapkit.mapview.MapView

class OrderDetailsFragment : Fragment() {

    private val viewModel by lazy {
        val order = OrderDetailsFragmentArgs.fromBundle(requireArguments()).selectedOrder
        ViewModelProvider(
            this,
            OrderDetailsViewModelFactory(order)
        ).get(OrderDetailsViewModel::class.java)
    }

    private lateinit var mapView: MapView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentOrderDetailsBinding.inflate(inflater)

        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        mapView = binding.mapview
        viewModel.selectedOrder.observe(viewLifecycleOwner) { order ->
            mapView.map.move(
                CameraPosition(
                    Point(
                        order.addressTo.latitude.toDouble(),
                        order.addressTo.longitude.toDouble()
                    ),
                    14.0f, 0.0f, 0.0f
                ),
                Animation(Animation.Type.SMOOTH, 5F),
                null
            )
        }

        return binding.root
    }

    override fun onStop() {
        mapView.onStop()
        MapKitFactory.getInstance().onStop()
        super.onStop()
    }

    override fun onStart() {
        super.onStart()
        MapKitFactory.getInstance().onStart()
        mapView.onStart()
    }
}