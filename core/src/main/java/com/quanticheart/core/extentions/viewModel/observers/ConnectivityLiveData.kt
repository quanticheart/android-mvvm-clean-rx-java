package com.quanticheart.core.extentions.viewModel.observers

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkInfo
import android.net.NetworkRequest
import android.os.Build
import androidx.lifecycle.LiveData

/**
 * A LiveData class which wraps the network connection status
 * Requires Permission: ACCESS_NETWORK_STATE
 *
 * https://www.brightec.co.uk/ideas/connectivitylivedata
 *
 * See https://developer.android.com/training/monitoring-device-state/connectivity-monitoring
 * See https://developer.android.com/reference/android/net/ConnectivityManager
 * See https://developer.android.com/reference/android/net/ConnectivityManager#CONNECTIVITY_ACTION
 */
class ConnectivityLiveData(private val context: Context?) : LiveData<Boolean>() {
    private var connectivityManager: ConnectivityManager? = null

    init {
        context?.let {
            connectivityManager =
                it.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        }
    }

    private val networkCallback = object : ConnectivityManager.NetworkCallback() {
        override fun onAvailable(network: Network?) {
            postValue(true)
        }

        override fun onLost(network: Network?) {
            postValue(false)
        }
    }

    @SuppressLint("MissingPermission")
    override fun onActive() {
        super.onActive()
        connectivityManager?.let {
            val activeNetwork: NetworkInfo? = connectivityManager!!.activeNetworkInfo
            postValue(activeNetwork?.isConnectedOrConnecting == true)

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                connectivityManager!!.registerDefaultNetworkCallback(networkCallback)
            } else {
                val builder = NetworkRequest.Builder()
                connectivityManager!!.registerNetworkCallback(builder.build(), networkCallback)
            }
        } ?: run { postValue(true) }
    }

    override fun onInactive() {
        super.onInactive()
        connectivityManager?.unregisterNetworkCallback(networkCallback)
    }
}