package com.example.MvvmCleanRxJava.rxJava.ConnectableObservable

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.MvvmCleanRxJava.R
import io.reactivex.Observable

class ConnectableObservable : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /**
         * ConnectableObservable
         */

        /**
         * Por padrão, cada vez que um Observer se registra em um Observable,
         * a sequência é enviada novamente. É possível fazer com que a mesma emissão seja enviada para
         * Observables diferentes utilizando a classe ConnectableObservable.
         * */
    }

    @SuppressLint("CheckResult")
    override fun onResume() {
        super.onResume()
        val observable = Observable.just("Event")
            .map { s ->
                println("Expensive operation for $s")
                s
            }
            .publish()
            .autoConnect(2)

        observable.subscribe { s -> println("Sub1 got: $s") }
        observable.subscribe { s -> println("Sub2 got: $s") }

        /**
         * Resultado
         * ---------------------------
         * Expensive operation for Event
         * Sub1 received: Event
         * Sub2 received: Event
         */

        /**
         * O método publish() retorna um ConnectableObservable no qual os Observers podem se registrar.
         * Foi utilizado o autoConnect(2) para determinar que as emissões podem começar após dois
         * observables se registrarem. Outra forma seria utilizar o método connect()
         * para que o envio seja realizado para todos os Observers.
         */
    }
}