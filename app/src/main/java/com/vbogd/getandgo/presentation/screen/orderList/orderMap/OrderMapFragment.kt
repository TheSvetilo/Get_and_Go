package com.vbogd.getandgo.presentation.screen.orderList.orderMap

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.vbogd.getandgo.R
import com.vbogd.getandgo.databinding.FragmentOrdersMapBinding
import com.yandex.mapkit.Animation
import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.map.CameraPosition
import com.yandex.mapkit.mapview.MapView
import com.yandex.runtime.image.ImageProvider

class OrderMapFragment : Fragment() {

    private lateinit var mapView: MapView
    private val viewModel: OrderMapViewModel by lazy {
        ViewModelProvider(this).get(OrderMapViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentOrdersMapBinding.inflate(inflater)

        mapView = binding.mapView
        binding.viewModel = viewModel

        viewModel.orders.observe(viewLifecycleOwner) { orderList ->
            mapView.map.move(
                CameraPosition(
                    Point(MAP_CENTRE_LAT, MAP_CENTRE_LON),
                    12F, 0.0F, 0.0F
                ),
                Animation(Animation.Type.SMOOTH, MAP_ANIMATION_DUR),
                null
            )
            for (point in orderList) {
                val placeMarker =
                    Point(point.addressTo.latitude.toDouble(), point.addressTo.longitude.toDouble())
                Log.d("TAG", point.id.toString())
                mapView.map.mapObjects.addPlacemark(placeMarker)
            }
        }

        return binding.root
    }

    companion object {
        const val MAP_CENTRE_LAT = 59.945933
        const val MAP_CENTRE_LON = 30.320045

        const val MAP_ANIMATION_DUR = 2F
    }
}