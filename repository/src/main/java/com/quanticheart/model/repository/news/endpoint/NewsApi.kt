package com.quanticheart.model.repository.news.endpoint

import com.quanticheart.model.repository.news.model.ResponseNews
import io.reactivex.Single
import retrofit2.http.GET

interface NewsApi {
    /**
     * https://newsapi.org/docs/endpoints/top-headlines
     */
    @GET("top-headlines?country=br")
    fun getTopNews(): Single<ResponseNews>
}