package com.example.MvvmCleanRxJava.rxJava.Emitter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.MvvmCleanRxJava.R
import io.reactivex.*

class EmitterMaybe : AppCompatActivity() {

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
         * Maybe
         */

        /**
         * Maybe (onSuccess ou onError ou onComplete). Esse emissor é usado quando se deseja retornar
         * um único valor opcional. Seus métodos são mutuamente exclusivos, ou seja, apenas um deles
         * é chamado. Se o dado existir, o onSuccess será chamado; se não existir, o onComplete será
         * invocado; ou se um erro ocorrer, o onError é disparado.
         */

        Maybe.create<String> { emitter ->
            emitter.onSuccess("Hello Maybe")
            emitter.onComplete()
            emitter.onError(Exception())
        }
    }

}