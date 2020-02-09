package com.quanticheart.domain.repository

import com.quanticheart.domain.model.News
import io.reactivex.Single

interface NewsRepository {
    fun getNews(): Single<List<News>>
}