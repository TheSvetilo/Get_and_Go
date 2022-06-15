package com.vbogd.getandgo.presentation.screen.orderList.orderMap

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.vbogd.getandgo.R
import com.vbogd.getandgo.databinding.FragmentOrdersMapBinding
import com.yandex.mapkit.Animation
import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.map.CameraPosition
import com.yandex.mapkit.mapview.MapView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OrderMapFragment : Fragment() {

    private lateinit var mapView: MapView
    private val viewModel: OrderMapViewModel by viewModels()

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

        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_order_list, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menuOrderList -> this.findNavController()
                .popBackStack()
        }
        return true
    }

    companion object {
        const val MAP_CENTRE_LAT = 59.945933
        const val MAP_CENTRE_LON = 30.320045

        const val MAP_ANIMATION_DUR = 2F
    }
}