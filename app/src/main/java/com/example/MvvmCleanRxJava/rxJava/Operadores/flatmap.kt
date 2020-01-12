package com.example.MvvmCleanRxJava.rxJava.Operadores

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.MvvmCleanRxJava.R
import io.reactivex.Observable

class flatmap : AppCompatActivity() {

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
         * flatMap
         */

        /**
         * O flatMap é bem similar ao map, a diferença principal é que a função utilizada retorna
         * um novo Observable (e não o dado modificado como no map). Isso é particularmente útil
         * ao precisar modificar o dado emitido utilizando um outro Observable.
         */

        /**
         * Perceba que nesse exemplo foi utilizado um outro Observable que emite o nome do sistema
         * operacional de acordo com o nome do fabricante. Imagine que estivéssemos acessando um web
         * service (ou o sistema de arquivos, por exemplo) para obter a lista de empresas e outro para
         * obter o nome do sistema operacional.Um detalhe importante é que o flatMap não mantém a
         * ordem dos valores emitidos.
         */

        fun getSO(company: String) =
            Observable.create<String> { emitter ->
                emitter.onNext(
                    when (company) {
                        "Apple" -> "iOS"
                        "Google" -> "Android"
                        "Microsoft" -> "Windows"
                        else -> "Desconhecido"
                    }
                )
                emitter.onComplete()
            }

        Observable.just("Apple", "Google", "Microsoft")
            .flatMap { s ->
                getSO(s)
            }
            .subscribe { println(it) }

    }
}