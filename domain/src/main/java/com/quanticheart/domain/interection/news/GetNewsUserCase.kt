package com.quanticheart.domain.interection.news

import com.quanticheart.domain.model.News
import io.reactivex.Single

interface GetNewsUserCase {
    fun getNews(): Single<List<News>>
}