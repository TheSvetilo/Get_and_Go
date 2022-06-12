package com.vbogd.getandgo

import android.app.Application
import com.yandex.mapkit.MapKitFactory

class App : Application() {

    companion object {
        const val MAPKIT_API_KEY = "2058688b-1593-42a3-8789-b3c09d1b4b9e"
    }

    override fun onCreate() {
        MapKitFactory.setApiKey(MAPKIT_API_KEY)
        MapKitFactory.initialize(this.applicationContext)
        super.onCreate()
    }
}