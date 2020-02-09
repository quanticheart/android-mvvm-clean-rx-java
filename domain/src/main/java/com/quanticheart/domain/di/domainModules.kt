package com.quanticheart.domain.di

import com.quanticheart.domain.interection.news.GetNewsUserCase
import com.quanticheart.domain.interection.news.GetNewsUserCaseImpl
import org.koin.dsl.module

val domainModule = module {
    factory<GetNewsUserCase> {
        GetNewsUserCaseImpl(
            get()
        )
    }
}