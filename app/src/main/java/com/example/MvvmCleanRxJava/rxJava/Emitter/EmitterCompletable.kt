package com.example.MvvmCleanRxJava.rxJava.Emitter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.MvvmCleanRxJava.R
import io.reactivex.*

class EmitterCompletable : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /**
         * Tipos de emissores
         */

        /**
         * Até agora falamos apenas do tipo de emissor Observable mas o RX possui outros tipos:
         */
    }

    override fun onResume() {
        super.onResume()

        /**
         * Completable
         */

        /**
         * Completable (onComplete ou onError). O Completable não emite dados.
         * ele é utilizado apenas saber se uma operação foi concluída com sucesso ou não.
         * Um exemplo muito comum no uso do Completable, é o acesso a uma REST API onde o
         * servidor pode retornar o status HTTP 204 (No content) indicando que a operação
         * foi bem sucedida, mas que não há nada para ser retornado para o cliente. Nesse caso,
         * o onComplete seria chamado. Caso algum erro aconteça, o onError será disparado.
         */

        Completable.create { emitter ->
            emitter.onComplete()
            emitter.onError(Exception())
        }
    }

}