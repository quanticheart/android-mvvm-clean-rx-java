@file:Suppress("MemberVisibilityCanBePrivate", "PropertyName")

package com.example.mvvmCleanRxJava.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.quanticheart.model.utils.ConnectivityStatus
import org.koin.core.KoinComponent
import org.koin.core.inject

abstract class BaseViewModel<T : Any, E> : ViewModel(), KoinComponent {
    //    protected val coroutineContext: CoroutineContextProvider by inject()
    private val connectivity: ConnectivityStatus by inject()
    protected val _viewState = MutableLiveData<ViewState<T>>()
    val viewState: LiveData<ViewState<T>>
        get() = _viewState
    protected val _viewEffects = MutableLiveData<E>()
    val viewEffects: LiveData<E>
        get() = _viewEffects

    protected fun executeUseCase(action: () -> Unit, noInternetAction: () -> Unit) {
        _viewState.value = Loading()
        if (connectivity.getStatusNet()) {
            action()
        } else {
            noInternetAction()
        }
    }

    protected fun executeUseCase(action: () -> Unit) {
        _viewState.value = Loading()
        action()
    }
}