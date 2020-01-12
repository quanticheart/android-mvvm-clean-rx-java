package com.example.MvvmCleanRxJava.rxJava.Emitter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.MvvmCleanRxJava.R
import io.reactivex.*

class EmitterSingle : AppCompatActivity() {

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
         * Single
         */

        /**
         * Single (onSuccess ou onError). Quando apenas um único valor obrigatório precisa ser
         * retornado, deve-se usar o emissor Single. Com ele, se o valor existir,
         * o método onSuccess será chamado, caso contrário, o método onError deve ser utilizado.
         */

        Single.create<String> { emitter ->
            emitter.onSuccess("Hello Single")
            emitter.onError(Exception())
        }
    }

}