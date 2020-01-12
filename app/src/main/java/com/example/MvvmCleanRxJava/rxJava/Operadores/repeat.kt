package com.example.MvvmCleanRxJava.rxJava.Operadores

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.MvvmCleanRxJava.R
import io.reactivex.Observable

class repeat : AppCompatActivity() {

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
         * repeat
         */

        /**
         * Cria um Observable que emite um item múltiplas vezes.
         */

        Observable.just("A", "B", "C")
            .repeat(2)
            .subscribe { print(it) }

        /**
         * Resultado
         * ---------------------------
         * ABCABC
         */


    }
}