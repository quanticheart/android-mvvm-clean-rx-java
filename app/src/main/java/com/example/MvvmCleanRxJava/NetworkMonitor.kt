/*
 *
 *  *                                     /@
 *  *                      __        __   /\/
 *  *                     /==\      /  \_/\/
 *  *                   /======\    \/\__ \__
 *  *                 /==/\  /\==\    /\_|__ \
 *  *              /==/    ||    \=\ / / / /_/
 *  *            /=/    /\ || /\   \=\/ /
 *  *         /===/   /   \||/   \   \===\
 *  *       /===/   /_________________ \===\
 *  *    /====/   / |                /  \====\
 *  *  /====/   /   |  _________    /      \===\
 *  *  /==/   /     | /   /  \ / / /         /===/
 *  * |===| /       |/   /____/ / /         /===/
 *  *  \==\             /\   / / /          /===/
 *  *  \===\__    \    /  \ / / /   /      /===/   ____                    __  _         __  __                __
 *  *    \==\ \    \\ /____/   /_\ //     /===/   / __ \__  ______  ____ _/ /_(_)____   / / / /__  ____ ______/ /_
 *  *    \===\ \   \\\\\\\/   ///////     /===/  / / / / / / / __ \/ __ `/ __/ / ___/  / /_/ / _ \/ __ `/ ___/ __/
 *  *      \==\/     \\\\/ / //////       /==/  / /_/ / /_/ / / / / /_/ / /_/ / /__   / __  /  __/ /_/ / /  / /_
 *  *      \==\     _ \\/ / /////        |==/   \___\_\__,_/_/ /_/\__,_/\__/_/\___/  /_/ /_/\___/\__,_/_/   \__/
 *  *        \==\  / \ / / ///          /===/
 *  *        \==\ /   / / /________/    /==/
 *  *          \==\  /               | /==/
 *  *          \=\  /________________|/=/
 *  *            \==\     _____     /==/
 *  *           / \===\   \   /   /===/
 *  *          / / /\===\  \_/  /===/
 *  *         / / /   \====\ /====/
 *  *        / / /      \===|===/
 *  *        |/_/         \===/
 *  *                       =
 *  *
 *  * Copyright(c) Developed by John Alves at 2019/6/20 at 8:21:15 for quantic heart studios
 *
 */

package com.example.mvvmCleanRxJava

import android.annotation.SuppressLint
import android.content.Context
import android.net.*
import android.net.ConnectivityManager.NetworkCallback
import com.quanticheart.core.extentions.logW

@Suppress("unused")
class NetworkMonitor : NetworkCallback() {

    private val networkRequest: NetworkRequest =
        NetworkRequest.Builder()
            .addTransportType(NetworkCapabilities.TRANSPORT_CELLULAR)
            .addTransportType(NetworkCapabilities.TRANSPORT_WIFI)
            .build()

    private var manager: ConnectivityManager? = null

    @SuppressLint("MissingPermission")
    fun enable(context: Context) {
        manager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        manager?.registerNetworkCallback(networkRequest, this)
    }

    // Likewise, you can have a disable method that simply calls ConnectivityManager.unregisterNetworkCallback(NetworkCallback) too.
    fun disable() {
        manager?.unregisterNetworkCallback(this)
    }

    @Suppress("DEPRECATION")
    @SuppressLint("MissingPermission")
    private fun getNetworkData(network: Network?): NetworkInfo? {
        return manager?.getNetworkInfo(network)
    }

    override fun onAvailable(network: Network?) {
        getNetworkData(network)?.let {
            "Network is Available. Network Info: $it".logW()
        }
    }

    override fun onUnavailable() {
        super.onUnavailable()
        "Network Unavailable".logW()
    }

    override fun onLost(network: Network?) {
        "Network Lost".logW()
    }

    override fun onLosing(network: Network?, maxMsToLive: Int) {
        "Network Losing.".logW()
    }

    override fun onCapabilitiesChanged(
        network: Network?,
        networkCapabilities: NetworkCapabilities?
    ) {
        getNetworkData(network)?.let {
            "Network Capabilities Changed. Network Info: $it ${networkCapabilities ?: ""}".logW()
        }
    }

    override fun onLinkPropertiesChanged(network: Network?, linkProperties: LinkProperties?) {
        getNetworkData(network)?.let {
            "Network Link Properties Changed. Network Info: $it ${linkProperties ?: ""}".logW()
        }
    }
}