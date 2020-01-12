package com.example.MvvmCleanRxJava.rxJava.Operadores

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.MvvmCleanRxJava.R
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

class mergeAndConcat : AppCompatActivity() {

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
         * concat x merge
         */

        /**
         * Ambos combinam as emissões. Como o nome diz, o concat concatena em ordem duas ou mais
         * emissões. Então um Observable só executará assim que seu antecessor terminar de emitir os itens.
         * Já o merge interpola as duas emissões, ou seja não mantém a ordem dos itens emitidos.
         */

        /**
         * Basicamente temos dois Observable emitindo seus dados com intervalos randômicos.
         * Perceba que foi utilizado Schedulers.newThread() pois se ambos os Observables
         * estiverem na mesma thread, o merge e o concat funcionarão da mesma forma.
         */

        /**
         * Usando o concat um resultado constante, primeiros os itens do Observable cidades
         * seria emitido, e só então os itens do Observable bb.
         */

        Observable.concat(cidades, bb)
            .subscribe { t -> print("$t, ") }

        /**
         * Resultado
         * ---------------------------
         * Tóquio, Rio, Berlim, Denver, Moscou, Nairobi, Helsinque, Oslo, Walt, Jesse, Skyler, Saul, Hank,
         */

        /**
         * Com o merge teríamos resultados variados, já os itens dos observables
         * são chamados de forma intercalada.
         */

        Observable.merge(cidades, bb)
            .subscribe { t -> print("$t, ") }

        /**
         * Resultado (variável)
         * ---------------------------
         * Walt, Jesse, Skyler, Tóquio, Rio, Berlim, Denver, Saul, Moscou, Nairobi, Helsinque, Hank, Oslo,
         */
    }

    fun getRandomDelay() = (Math.random() * 3).toLong() * 1000L

    val cidades = Observable.create<String> { emitter ->
        listOf(
            "Tóquio", "Rio", "Berlim", "Denver",
            "Moscou", "Nairobi", "Helsinque", "Oslo"
        ).forEach {
            Thread.sleep(getRandomDelay())
            emitter.onNext(it)
        }
        emitter.onComplete()
    }.subscribeOn(Schedulers.newThread())

    val bb = Observable.create<String> { emitter ->
        listOf("Walt", "Jesse", "Skyler", "Saul", "Hank")
            .forEach {
                Thread.sleep(getRandomDelay())
                emitter.onNext(it)
            }
        emitter.onComplete()
    }.subscribeOn(Schedulers.newThread())
}