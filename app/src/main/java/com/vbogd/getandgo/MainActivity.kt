package com.vbogd.getandgo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.vbogd.getandgo.presentation.screen.orderDetails.OrderDetailsFragment
import com.yandex.mapkit.MapKitFactory

class MainActivity : AppCompatActivity() {

    companion object {
        const val MAPKIT_API_KEY = "2058688b-1593-42a3-8789-b3c09d1b4b9e"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        MapKitFactory.setApiKey(MAPKIT_API_KEY)
        MapKitFactory.initialize(this.applicationContext)

        setContentView(R.layout.activity_main)
    }
}