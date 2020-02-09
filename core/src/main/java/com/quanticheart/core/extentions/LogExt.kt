@file:Suppress("unused", "MayBeConstant")

package com.quanticheart.core.extentions

import android.util.Log

fun String?.logW() = Log.w(LOG_TAG, verifyLogMsg(this))
fun Long?.logW() = Log.w(LOG_TAG, verifyLogMsg(this))
fun Int?.logW() = Log.w(LOG_TAG, verifyLogMsg(this))
fun Boolean?.logW() = Log.w(LOG_TAG, verifyLogMsg(this))

private val LOG_TAG = "App Alert"
private fun <T> verifyLogMsg(msg: T?): String {
    return msg?.toString() ?: ""
}
