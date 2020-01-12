package com.example.MvvmCleanRxJava.retrofit.model.base

import java.io.Serializable

open class BaseResponse<T> : Serializable {
    var msg: String = ""
    var success: Boolean = false
    var response: T? = null
}