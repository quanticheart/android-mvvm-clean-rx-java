package com.example.mvvmCleanRxJava.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvvmCleanRxJava.application.AppApplication
import com.quanticheart.core.extentions.viewModel.base.BaseViewModel
import com.quanticheart.domain.interection.news.GetNewsUserCase
import com.quanticheart.domain.model.News

class MainActivityViewModel(private val userCase: GetNewsUserCase) :
    BaseViewModel(AppApplication.context) {

    private val listNews: MutableLiveData<List<News>> = MutableLiveData()

    fun getList(): LiveData<List<News>> = listNews

    fun getNewsListFromWs() {
        executeUseCase {
            userCase.getNews().execute({
                listNews.value = it
            }, {
                it.errorUserCase()
            })
        }
    }
}