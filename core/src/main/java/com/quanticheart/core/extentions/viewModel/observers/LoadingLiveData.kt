package com.quanticheart.core.extentions.viewModel.observers

import androidx.lifecycle.LiveData

class LoadingLiveData : LiveData<Boolean>() {

//    init {
//        postValue(false)
//    }

    fun show() {
        postValue(true)
    }

    fun hide() {
        postValue(false)
    }
}