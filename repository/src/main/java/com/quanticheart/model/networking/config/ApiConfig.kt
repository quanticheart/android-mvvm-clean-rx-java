package com.quanticheart.model.networking.config

import com.quanticheart.connection.model.ConnectionModel
import com.quanticheart.model.networking.endpoint.EndpointPosts

object ApiConfig {

    /**
     * Base project URL
     */
    var BASE_URL = "https://gorest.co.in/public-api/"

    /**
     * Default Header
     */
    var HEADER: HashMap<String, String> = hashMapOf(
        "Authorization" to "Bearer AEsu1_Zx8yLW8NPSSVWUoeRzt2CjJqnLIBU0",
        "ApiToken" to "APIKEYHERE"
    )

    /**
     * Connection Api TimerOut
     */
    var TIMER_OUT_MINUTE = 2

    /**
     * Default Retrofit Api List
     */
    var API_INTERFACE_LIST = EndpointPosts::class.java

    /**
     * get Model for connection
     */
    fun getConnModel(): ConnectionModel =
        ConnectionModel(BASE_URL, API_INTERFACE_LIST, HEADER, TIMER_OUT_MINUTE)
}