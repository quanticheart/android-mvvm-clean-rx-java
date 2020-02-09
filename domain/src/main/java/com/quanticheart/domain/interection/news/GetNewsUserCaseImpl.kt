package com.quanticheart.domain.interection.news

import com.quanticheart.domain.interection.news.GetNewsUserCase
import com.quanticheart.domain.model.News
import com.quanticheart.domain.repository.NewsRepository
import io.reactivex.Single

class GetNewsUserCaseImpl(private val repository: NewsRepository) :
    GetNewsUserCase {
    override fun getNews(): Single<List<News>> = repository.getNews()
}