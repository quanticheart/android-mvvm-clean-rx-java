package com.example.mvvmCleanRxJava.di

import com.example.mvvmCleanRxJava.ui.MainActivityViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModule = module {
    viewModel { MainActivityViewModel(get()) }
}