package com.quanticheart.model.repository.news

import com.quanticheart.domain.model.News
import com.quanticheart.domain.repository.NewsRepository
import com.quanticheart.model.extentions.defaultConfig
import com.quanticheart.model.repository.news.endpoint.NewsApi
import io.reactivex.Single

class NewsRepositoryImpl : NewsRepository {
    /**
     * This site for get new ApiToken
     *
     * https://gorest.co.in/rest-console.html
     */
    override fun getNews(): Single<List<News>> {
        return Repository.getNews().getTopNews()
            .defaultConfig()
            .map { response ->
                val list = ArrayList<News>()
                response.articles!!.forEachIndexed { index, article ->
                    list.add(News(index, article.title, article.urlToImage))
                }
                list.toList()
            }
    }
}

