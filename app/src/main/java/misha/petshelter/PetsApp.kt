package misha.petshelter

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class PetsApp: Application() {

    override fun onCreate() {
        super.onCreate()
    }
}