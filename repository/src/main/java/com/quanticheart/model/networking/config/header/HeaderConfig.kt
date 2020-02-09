package com.quanticheart.model.networking.config.header

import com.quanticheart.connection.base.ApiBaseConfig

abstract class HeaderConfig : ApiBaseConfig() {
    /**
     * Base project URL
     *
     * https://newsapi.org/docs/get-started
     */
    override var BASE_URL = "https://newsapi.org/v2/"

    /**
     * Default Header
     */
    override var HEADER: HashMap<String, String> = hashMapOf(
        "X-Api-Key" to "ac3c014d8b6b43c5a16fc12157467287"
    )
}