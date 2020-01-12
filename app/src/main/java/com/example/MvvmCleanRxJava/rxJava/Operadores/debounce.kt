package com.example.MvvmCleanRxJava.rxJava.Operadores

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.MvvmCleanRxJava.R
import io.reactivex.Observable
import java.util.concurrent.TimeUnit

class debounce : AppCompatActivity() {

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
         * debounce
         */

        /**
         * Somente emite um item de um Observable se um determinado tempo passou sem emitir um outro item.
         */

        Observable.create<Int> { emitter ->
            emitter.onNext(1)
            Thread.sleep(400) // 400 < 500, descarta o 1
            emitter.onNext(2)
            Thread.sleep(600) // 600 > 500, emite o 2
            emitter.onNext(3)
            Thread.sleep(100) // 100 < 500, descarta o 3
            emitter.onNext(4)
            Thread.sleep(600) // 600 > 500, emite o 4
            emitter.onNext(5)
            Thread.sleep(600) // 600 > 500, emite o 5
            emitter.onComplete()
        }.debounce(500, TimeUnit.MILLISECONDS)
            .subscribe { i ->
                println(i.toString())
            }

        /**
         * Resultado
         * ---------------------------
         * 2
         * 4
         * 5
         */
    }
}