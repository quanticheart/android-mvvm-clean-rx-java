package com.quanticheart.domain.di

import com.quanticheart.domain.interection.GetPostUserCase
import com.quanticheart.domain.interection.GetPostUserCaseImpl
import org.koin.dsl.module

val interactionModule = module {
    factory<GetPostUserCase> { GetPostUserCaseImpl(get()) }
}