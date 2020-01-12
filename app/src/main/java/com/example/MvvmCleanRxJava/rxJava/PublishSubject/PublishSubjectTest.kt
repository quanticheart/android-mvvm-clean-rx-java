package com.example.MvvmCleanRxJava.rxJava.PublishSubject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.MvvmCleanRxJava.R
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.subjects.PublishSubject
import kotlinx.android.synthetic.main.activity_publish_subject.*

class PublishSubjectTest : AppCompatActivity() {

    val source = PublishSubject.create<String>()
    val disposables = CompositeDisposable()
    var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /**
         * PublishSubject
         */

        /**
         * A classe PublishSubject é uma subclasse de Subject e funciona como Observable e
         * Observer ao mesmo tempo. Pois além receber dados (como um Observer) ele também emite (como um Observable).
         * Desta forma, um Subject possui acesso aos
         * métodos onNext, onComplete e onError (no Observer esses métodos estão disponíveis apenas internamente).
         */

        disposables.add(
            source.subscribe(
                { dado -> textView.text = dado },
                { e -> textView.text = "Erro" }
            )
        )
        button.setOnClickListener {
            source.onNext("Mensagem ${++count}")
            if (count == 10) {
                source.onComplete()
            }
        }

        /**
         * Nesse exemplo, quando o botão é clicado, um novo dado é emitido pelo PublishSubject
         * e a variável count é incrementada. Com isso, o Observer registrado no método subscribe
         * é chamado e o texto do TextView é atualizado. Quando count chegar a 10,
         * onComplete é chamado e a sequência termina.
         */
    }

    override fun onDestroy() {
        super.onDestroy()
        disposables.clear()
    }
}