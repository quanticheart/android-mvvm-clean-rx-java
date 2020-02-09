package com.quanticheart.model.repository.news

import com.quanticheart.connection.client.RetrofitClient
import com.quanticheart.model.networking.config.NewsApiConfig
import com.quanticheart.model.repository.news.endpoint.NewsApi

object Repository {
    fun getNews(): NewsApi =
        (RetrofitClient.getConnect(NewsApiConfig.getConnConfig()) as NewsApi)
}