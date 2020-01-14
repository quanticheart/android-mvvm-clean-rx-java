package com.quanticheart.model.networking.endpoint

import com.quanticheart.model.repository.posts.entitys.ResponsePosts
import io.reactivex.Single
import retrofit2.http.GET

interface EndpointPosts {
    @GET("posts")
    fun getPosts(): Single<ResponsePosts>
}