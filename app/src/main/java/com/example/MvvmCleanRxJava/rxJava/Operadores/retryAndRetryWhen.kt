package com.example.MvvmCleanRxJava.rxJava.Operadores

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.MvvmCleanRxJava.R
import io.reactivex.Observable
import java.util.concurrent.TimeUnit

class retryAndRetryWhen : AppCompatActivity() {

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
         * retry & retryWhen
         */

        /**
         * Se um observable emitir um erro, é possível tentar novamente na
         * esperança que ele complete sem erros.
         */

        Observable.create<String> { emitter ->
            val numero = (Math.random() * 10).toInt()
            if (numero < 5) {
                emitter.onNext("Sucesso!")
                emitter.onComplete()
            } else {
                emitter.onError(RuntimeException("Falhou! Tente de novo"))
            }
        }.retry(2)
            .subscribe(
                { s -> println("TERMINEI! $s") },
                { e -> println("Erro") }
            )

        /**
         * Resultado
         * (Varia de acordo com o número gerado)
         * ---------------------------
         * TERMINEI! Sucesso!
         */

        /**
         * Se o número gerado for maior ou igual a 5, um erro será gerado, mas o onError não
         * será chamado imediatamente, pois estamos informando para o Observable tentar novamente
         * por até duas vezes (com retry(2) ). O onError só será chamado se as duas chamadas seguintes
         * não gerarem um número menor que 5.
         */

        /**
         * Usamos esse exemplo, mas imagine que você está fazendo uma requisição a um servidor web,
         * e por alguma razão a primeira chamada falhou. Você pode fazer isso usando o retry,
         * mas o retryWhen permite tentar novamente apenas se uma determinada condição for satisfeita,
         * inclusive permitindo um delay para a nova tentativa.
         */

        Observable.create<String> { emitter ->
            val numero = (Math.random() * 10).toInt()
            if (numero < 5) {
                emitter.onNext("Sucesso!")
                emitter.onComplete()
            } else {
                emitter.onError(RuntimeException("Falhou! Tente de novo"))
            }
        }.retryWhen { completed ->
            completed.delay(2, TimeUnit.SECONDS)
        }.subscribe(
            { s -> println("TERMINEI! $s") },
            { e -> println("Erro") }
        )

        /**
         * Igual ao exemplo anterior, mas a nova tentativa só ocorre após 2 segundos.
         */
    }
}