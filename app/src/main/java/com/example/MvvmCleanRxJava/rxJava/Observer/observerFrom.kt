package com.example.MvvmCleanRxJava.rxJava.Observer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.MvvmCleanRxJava.R
import com.example.MvvmCleanRxJava.utils.MsgUtil
import io.reactivex.Observable

class observerFrom : AppCompatActivity() {

    /**
     * https://medium.com/@nglauber/introdu%C3%A7%C3%A3o-ao-rx-java-com-kotlin-90c58d184c6b
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /**
         * from
         */

        /**
         * Existem algumas variações do método from para criar um Observable.
         * Abaixo estão sendo listadas duas delas:
         */

        /**
         * Os nomes dos métodos são auto-explicativos. Perceba que o lambda passado para no subscribe
         * passado para o Observable criado pelo método fromArray é chamado 3 vezes
         * (uma para cada item emitido). Outro detalhe desse exemplo é que foram passados
         * três lambdas para o Observable criado com o fromIterable que representam respectivamente
         * os métodos: onNext, onError e onComplete.
         */

        Observable.fromArray("Google", "Micro", "App").subscribe { array ->
            MsgUtil.log(array)
        }

        Observable.fromIterable(listOf("Google", "Micro", "App")).subscribe(
            { MsgUtil.log(it) },                               // onNext
            { e -> println(e.message) },                      // onError
            { MsgUtil.log("fromIterable Complete, hide load") }      // onComplete
        )
    }
}
