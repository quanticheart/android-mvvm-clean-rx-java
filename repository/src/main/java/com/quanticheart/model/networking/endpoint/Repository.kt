package com.quanticheart.model.networking.endpoint

import com.quanticheart.connection.client.RetrofitClient
import com.quanticheart.model.networking.config.ApiConfig

object Repository {

    fun getPostsConection(): EndpointPosts =
        (RetrofitClient.getConnect(ApiConfig.getConnModel()) as EndpointPosts)

}