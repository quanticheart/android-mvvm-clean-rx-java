package com.example.MvvmCleanRxJava.rxJava.Schedulers

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.MvvmCleanRxJava.R
import com.example.MvvmCleanRxJava.utils.MsgUtil
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class Schedules : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        /**
         * Schedulers
         */

        /**
         * Schedulers determinam a thread em que o emissor emitirá seu fluxo de dados e a
         * thread em que os Observers consumirão essas informações.
         */

        /**
         * Os Schedulers são passados respectivamente nos métodos subscribeOn e observeOn.
         * Os principais Schedulers são:
         *
         * + Main Thread (AndrdoiSchedulers.mainThread()
         * + Computation (Schedulers.computation())
         * + I/O ( Schedulers.io())
         * + Nova thread (Schedulers.newThread())
         */

        Observable.just("Rx Go!")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { msg -> MsgUtil.log(msg) },                           // onNext
                { e -> println(e.message) },                           // onError
                { MsgUtil.log("Just Complete, hide load") }      // onComplete
            )
    }
}