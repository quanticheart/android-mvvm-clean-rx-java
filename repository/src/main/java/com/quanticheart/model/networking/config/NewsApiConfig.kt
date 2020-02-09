package com.quanticheart.model.networking.config

import com.quanticheart.model.networking.config.header.HeaderConfig
import com.quanticheart.model.repository.news.endpoint.NewsApi

object NewsApiConfig : HeaderConfig() {
    /**
     * Default Retrofit Api List
     */
    override var API_INTERFACE_LIST: Class<*> = NewsApi::class.java
}