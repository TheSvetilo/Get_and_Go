package com.vbogd.getandgo.presentation.screen.orderList.orderMap

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.vbogd.getandgo.databinding.FragmentOrdersMapBinding
import com.yandex.mapkit.mapview.MapView

class OrderMapFragment : Fragment() {

    private lateinit var mapView: MapView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentOrdersMapBinding.inflate(inflater)

        mapView = binding.mapView


        return binding.root
    }

}