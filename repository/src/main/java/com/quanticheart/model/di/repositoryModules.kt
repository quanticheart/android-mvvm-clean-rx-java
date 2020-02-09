package com.quanticheart.model.di

import com.quanticheart.domain.repository.NewsRepository
import com.quanticheart.model.repository.news.NewsRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    factory<NewsRepository> { NewsRepositoryImpl() }
}