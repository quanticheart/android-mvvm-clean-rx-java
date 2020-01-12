package com.example.MvvmCleanRxJava.rxJava.Operadores

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.MvvmCleanRxJava.R
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

class take : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /**
         * Operadores
         */

        /**
         * Os operadores manipulam os itens entre o produtor (Observable) e o consumidor (Observer).
         * O RX Java tem uma infinidade de operadores, vou listar apenas alguns principais aqui.
         */
    }

    @SuppressLint("CheckResult")
    override fun onResume() {
        super.onResume()

        /**
         * take
         */

        /**
         * Consome apenas os primeiros N itens emitidos por um Observable.
         * Vejamos um exemplo simples.
         */

        Observable.just(1, 2, 3)
            .take(2)
            .subscribe { print("$it ") }

        /**
         * Resultado
         * ---------------------------
         * 1 2
         */

        fun getRandomDelay() = (Math.random() * 5).toLong() * 1000L

        val cache =
            Observable.create<String> {
                Thread.sleep(getRandomDelay())
                it.onNext("Cache")
                it.onComplete()
            }.subscribeOn(Schedulers.newThread())

        val network =
            Observable.create<String> {
                Thread.sleep(getRandomDelay())
                it.onNext("Network")
                it.onComplete()
            }.subscribeOn(Schedulers.newThread())

        Observable.merge(cache, network)
            .take(1)
            .subscribe { s -> println(s) }

        /**
         * Resultado
         *---------------------------
         * depende. Cache ou Network
         */

        /**
         * O código acima simula uma situação bem comum. Imagine que você tem uma informação na web
         * e a mesma informação pode estar salva localmente no cache. Você pode realizar ambas
         * as requisições (com o operador merge) solicitando o mesmo dado, e só pegar a primeira
         * que foi retornada com o take(1).
         * Note que novamente foi utilizado o Schedulers.newThread().
         */
    }
}