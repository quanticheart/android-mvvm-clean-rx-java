package com.example.mvvmCleanRxJava.application

import android.app.Application
import com.example.mvvmCleanRxJava.di.viewModule
import com.quanticheart.domain.di.domainModule
import com.quanticheart.model.di.repositoryModule
import org.koin.core.context.startKoin

class AppApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(view + domain + repository)
        }
    }

    private val view = listOf(viewModule)
    private val domain = listOf(domainModule)
    private val repository = listOf(repositoryModule)
}