package com.example.MvvmCleanRxJava.retrofit.model.config

object ApiConfig {

    /**
     * Base project URL
     */
    var BASE_URL = "https://gorest.co.in/public-api/"

    /**
     * Header
     */
    var HEADER: HashMap<String, String> = hashMapOf(
        "Authorization" to "Bearer Izw8NApr57Vjdx9Q4aimbE2oA11ditxC3FuY",
        "ApiToken" to "APIKEYHERE"
    )

    /**
     * Api TimerOut
     */
    var TIMER_OUT_MINUTE = 2
}