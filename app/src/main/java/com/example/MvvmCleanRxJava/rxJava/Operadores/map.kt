package com.example.MvvmCleanRxJava.rxJava.Operadores

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.MvvmCleanRxJava.R
import io.reactivex.Observable

class map : AppCompatActivity() {

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
         * map
         */

        /**
         * Transforma os itens emitidos por um Observable aplicando uma função para cada item.
         */

        /**
         * O Observable está emitindo o nome das empresas, mas o método map transformou cada
         * String emitida em um Pair (utilizando a extension function to) onde a chave é o nome da
         * empresa e o valor é a quantidade de caracteres do nome da empresa.
         */

        Observable.fromArray("Google", "Microsoft", "Apple")
            .map { it to it.length }
            .subscribe { pair ->
                val (name, length) = pair
                println("$name - $length")
            }

        Observable.fromArray("Google", "Microsoft", "Apple")
            .map { it to "$it with map" }
            .subscribe { pair ->
                val (name, title) = pair
                println("$name - $title")
            }

        Observable.fromArray("Google", "Microsoft", "Apple")
            .map { it to (it.length > 5) }
            .subscribe { pair ->
                println("${pair.first} - ${pair.second}")
            }
    }
}