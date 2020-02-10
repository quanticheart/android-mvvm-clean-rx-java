@file:Suppress("MemberVisibilityCanBePrivate", "PropertyName")

package com.quanticheart.core.extentions.viewModel.base

import android.annotation.SuppressLint
import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.quanticheart.core.extentions.viewModel.observers.ConnectivityLiveData
import com.quanticheart.core.extentions.viewModel.observers.LoadingLiveData
import io.reactivex.Single

/**
 * extends KoinComponent necessary for dependence inject
 */
abstract class BaseViewModel(context: Context? = null) : ViewModel() {

    /**
     * This Vars for control Errors conn
     */
    protected val _error: MutableLiveData<Throwable> = MutableLiveData()
    val errorStatus: LiveData<Throwable>
        get() = _error

    protected fun Throwable.errorUserCase() {
        _error.value = this
    }

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
    protected val _loadingState = LoadingLiveData()
    val loading: LiveData<Boolean>
        get() = _loadingState

    protected fun finishUserCase() {
        _loadingState.hide()
    }

    protected fun initUserCase() {
        _loadingState.show()
    }

    /**
     * Exec funs for view model
     */
    protected fun executeUseCase(action: () -> Unit, noInternetAction: () -> Unit) {
        if (connectionStatus.value == true) {
            action()
        } else {
            noInternetAction()
        }
    }

    protected fun executeUseCase(action: () -> Unit) {
        if (connectionStatus.value == true) {
            initUserCase()
            action()
        }
    }

    protected fun executeUseCaseWithouLoading(action: () -> Unit, noInternetAction: () -> Unit) {
        if (connectionStatus.value == true) {
            action()
        } else {
            noInternetAction()
        }
    }

    protected fun executeUseCaseWithouLoading(action: () -> Unit) {
        action()
    }

    @SuppressLint("CheckResult")
    protected fun <T> Single<T>.execute(success: (T) -> Unit) {
        this.subscribe({
            success(it)
            finishUserCase()
        }, {
            finishUserCase()
        })
    }

    @SuppressLint("CheckResult")
    protected fun <T> Single<T>.execute(success: (T) -> Unit, error: (Throwable) -> Unit) {
        this.subscribe({
            success(it)
            finishUserCase()
        }, {
            error(it)
            finishUserCase()
        })
    }
}