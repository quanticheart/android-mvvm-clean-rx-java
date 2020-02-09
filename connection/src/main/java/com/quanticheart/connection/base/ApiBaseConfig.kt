@file:Suppress("PropertyName")

package com.quanticheart.connection.base

import com.quanticheart.connection.model.ConnectionModel

abstract class ApiBaseConfig {

    /**
     * Base project URL
     */
    abstract var BASE_URL: String
    /**
     * Default Header
     */
    abstract var HEADER: HashMap<String, String>

    /**
     * Connection Api TimerOut
     */
    var TIMER_OUT_MINUTE = 2

    /**
     * Default Retrofit Api List
     */
    abstract var API_INTERFACE_LIST: Class<*>

    /**
     * get Model for connection
     */
    fun getConnConfig(): ConnectionModel =
        ConnectionModel(BASE_URL, API_INTERFACE_LIST, HEADER, TIMER_OUT_MINUTE)

}