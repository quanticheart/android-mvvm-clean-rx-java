package com.quanticheart.model.extentions

import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

fun <T> Single<T>.defaultConfig(): Single<T> =
    this.observeOn(AndroidSchedulers.mainThread())
        .subscribeOn(Schedulers.io())