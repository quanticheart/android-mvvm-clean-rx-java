package com.example.MvvmCleanRxJava.rxJava.Emitter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.MvvmCleanRxJava.R
import io.reactivex.*

class EmitterFlowable : AppCompatActivity() {

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
         * Flowable
         */

        /**
         * Flowable (onNext, onError e onComplete) igual ao Observable,
         * mas suporta o conceito de Back pressure.
         */

        Flowable.create<String> ({ emitter ->
            emitter.onNext("Hello Flowable")
            emitter.onComplete()
            emitter.onError(Exception())
        }, BackpressureStrategy.BUFFER)
    }

}