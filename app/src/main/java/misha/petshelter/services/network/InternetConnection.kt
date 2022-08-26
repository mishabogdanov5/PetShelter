package misha.petshelter.services.network

import android.content.Context
import android.net.ConnectivityManager


fun isConnected(context: Context): Boolean {
    val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

    return cm.activeNetworkInfo != null && cm.activeNetworkInfo!!.isConnected
}