package com.example.MvvmCleanRxJava.retrofit.model

import com.example.MvvmCleanRxJava.retrofit.domain.post.Post
import io.reactivex.Single
import retrofit2.http.GET

interface ApiList {
    @GET("posts")
    fun getPosts(): Single<Post>
}