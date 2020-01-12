package com.example.MvvmCleanRxJava.rxJava.Observable

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.MvvmCleanRxJava.R
import io.reactivex.Observable

class OnDo : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        /**
         * doOnSubscribe, doOnNext, doOnError, doOnComplete, …
         */

        /**
         * Esses métodos são chamados quando as respectivas ações são chamadas no Observable.
         */

        /**
        Resultado
        ---------------------------
        Subscribed!
        Emitiu: Hello
        Subscribe
        Complete!
         */

        /**
         * Existem ainda outros métodos que podem ser úteis, tais como: doAfterNext, doFinally,
         * doOnDispose, entre outros.
         */

        Observable.just("Hello")
            .doOnSubscribe { println("Subscribed!") }
            .doOnNext { s -> println("Emitiu: $s") }
            .doOnError { e -> println("Deu Erro: $e") }
            .doOnComplete { println("Complete!") }
            .subscribe { println("Subscribe") }
    }
}