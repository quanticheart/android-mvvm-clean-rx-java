package com.example.MvvmCleanRxJava.rxJava.Schedulers

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.MvvmCleanRxJava.R
import io.reactivex.Observable
import io.reactivex.ObservableTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class Transformer : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()

        /**
         * Transformers
         */

        /**
         * Para evitar ter que utilizar várias vezes o subscribeOn e o observeOn, podemos criar
         * um ObservableTransformer e utiliza-lo com o método compose.
         */

        Observable.just("a", "b", "c")
            .compose(applyObservableAsync())
            .subscribe { letra-> print(letra) }
    }

    fun <T> applyObservableAsync(): ObservableTransformer<T, T> {
        return ObservableTransformer { observable ->
            observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
        }
    }
}