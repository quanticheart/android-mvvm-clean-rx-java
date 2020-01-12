package com.example.MvvmCleanRxJava.rxJava.Operadores

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.MvvmCleanRxJava.R
import io.reactivex.Observable

class filter : AppCompatActivity() {

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
         * filter
         */

        /**
         * Realiza uma filtragem para emitir apenas os itens que satisfaçam
         * uma determinada condição.
         */

        Observable.fromArray(1, 2, 3, 4, 5, 6, 7, 8)
            .filter { i -> i % 2 == 0 }
            .subscribe { i -> print("$i, ") }

        Observable.fromArray("Apple", "Google", "Microsoft")
            .filter { i -> i == "Google" }
            .subscribe { i -> print("$i - Android encontrado ") }
    }
}