package com.quanticheart.connection.utils

import android.content.Context
import android.net.ConnectivityManager

@Suppress("unused")
open class ConnectivityImpl(private val context: Context) : Connectivity {

    @Suppress("DEPRECATION")
    override fun hasNetworkAccess(): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val info = connectivityManager.activeNetworkInfo
        return info != null && info.isConnected
    }
}