@file:Suppress("MemberVisibilityCanBePrivate", "PropertyName")

package com.quanticheart.core.extentions.viewModel.base

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.quanticheart.core.extentions.viewModel.observers.ConnectivityLiveData
import com.quanticheart.core.extentions.viewModel.observers.LoadingLiveData

/**
 * extends KoinComponent necessary for dependence inject
 */
abstract class BaseViewModel(context: Context? = null) : ViewModel() {

    /**
     * This Vars for control conn status
     */
    protected val _connState: ConnectivityLiveData =
        ConnectivityLiveData(
            context
        )
    val connectionStatus: LiveData<Boolean>
        get() = _connState

    /**
     * This Vars for control loading status
     */
    protected val _loadingState =
        LoadingLiveData()
    val loading: LiveData<Boolean>
        get() = _loadingState

    protected fun finishUserCase() {
        _loadingState.hide()
    }

    /**
     * Exec funs for view model
     */
    protected fun executeUseCase(action: () -> Unit, noInternetAction: () -> Unit) {
        _loadingState.show()
        if (connectionStatus.value == true) {
            action()
        } else {
            noInternetAction()
        }
    }

    protected fun executeUseCase(action: () -> Unit) {
        _loadingState.show()
        action()
    }

    protected fun executeUseCaseWithouLoading(action: () -> Unit, noInternetAction: () -> Unit) {
        if (connectionStatus.value == true) {
            action()
        } else {
            noInternetAction()
        }
    }

    protected fun executeUseCaseWithouLoading(action: () -> Unit) {
        if (connectionStatus.value == true) {
            action()
        }
    }
}