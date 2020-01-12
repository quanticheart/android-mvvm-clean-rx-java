package com.example.MvvmCleanRxJava.rxJava.Observable

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.MvvmCleanRxJava.R
import com.example.MvvmCleanRxJava.utils.MsgUtil
import io.reactivex.Observable

class CreateObservable : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()

        /**
         * Create
         */

        /**
         * Permite criar um Observable “do zero”. Assim, cabe a você chamar cada método do Observer:
         * onNext para cada item emitido; onComplete ao terminar a sequência; e onError em caso de erro.
         */

        /**
         * A função acima está criando um Observable que emitirá os itens de uma lista. Caso algum
         * item da lista seja vazio, um erro será gerado e a sequência será interrompida.
         * Perceba que o parâmetro emitter será responsável por chamar os métodos onNext,
         * onComplete e eventualmente o onError.
         */

        getObservableFromList(listOf("Google", "", "Micro")).subscribe(
            { result -> MsgUtil.log(result) },
            { e -> MsgUtil.log(e.message ?: "") },
            { MsgUtil.log("Custom Complete") }
        )
    }

    private fun getObservableFromList(lista: List<String>) =
        Observable.create<String> { emitter ->
            lista.forEach { nome ->
                if (nome == "") {
                    emitter.onError(Exception("Valor em branco"))
                }
                emitter.onNext(nome)
            }
            emitter.onComplete()
        }
}