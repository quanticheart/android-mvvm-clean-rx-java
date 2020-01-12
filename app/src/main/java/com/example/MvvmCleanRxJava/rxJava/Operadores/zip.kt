package com.example.MvvmCleanRxJava.rxJava.Operadores

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.MvvmCleanRxJava.R
import io.reactivex.Observable
import io.reactivex.functions.BiFunction
import io.reactivex.functions.Function3
import io.reactivex.functions.Function4
import io.reactivex.functions.Function5

class zip : AppCompatActivity() {

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
         * zip
         */

        /**
         * O operador zip é um dos que mais demonstra o poder o RX Java. Ele combina as emissões
         * de dois ou mais Observables por meio de uma função e emite um item para cada combinação
         * desses Observables.
         */

        /**
         * A BiFunction é triplamente tipada <String, String, String>, sendo os tipos, respectivamente:
         * o do primeiro Observable, o do segundo Observable e o tipo de retorno da função. Perceba que
         * o valor "Phoebe" não foi emitido porque não houve uma emissão correspondente no segundo Observable
         * (e porque eu não gosto dela ☺).
         *
         * Caso precise de mais Observables, ao invés da BiFunction, você pode usar Function3,
         * Function4, …, Function9.
         */

        /**
         * Resultado
         * ---------------------------
         * Joey = Barney
         * Ross = Ted
         * Chandler = Marshall
         * Monica = Lily
         * Rachel = Robin
         */
        Observable.zip(
            Observable.just(
                "Joey", "Ross", "Chandler", "Monica", "Rachel", "Phoebe"
            ),
            Observable.just(
                "Barney", "Ted", "Marshall", "Lily", "Robin"
            ),
            BiFunction<String, String, String> { friend, himym ->
                "$friend $himym"
            }
        ).subscribe { t -> println(t) }

        Observable.zip(
            Observable.just(
                "Joey", "Ross", "Chandler", "Monica", "Rachel", "Phoebe"
            ),
            Observable.just(
                1, 2, 3, 4, 5, 6
            ),
            BiFunction<String, Int, String> { friend, number ->
                "$friend $number"
            }
        ).subscribe { t -> println(t) }

        Observable.zip(
            Observable.just(
                "Joey", "Ross", "Chandler", "Monica", "Rachel", "Phoebe"
            ),
            Observable.just(
                "Barney", "Ted", "Marshall", "Lily", "Robin"
            ),
            Observable.just(
                1, 2, 3, 4, 5, 6
            ),
            Function3<String, String, Int, String> { friend, himym, number ->
                "$friend $himym $number"
            }
        ).subscribe { t -> println(t) }

        Observable.zip(
            Observable.just(
                "Joey", "Ross", "Chandler", "Monica", "Rachel", "Phoebe"
            ),
            Observable.just(
                "Barney", "Ted", "Marshall", "Lily", "Robin"
            ),
            Observable.just(
                1, 2, 3, 4, 5
            ),
            Observable.just(
                false, true, false, true, false, false
            ),
            Function4<String, String, Int, Boolean, String> { friend, himym, number, ok ->
                "$friend $himym $number = $ok"
            }
        ).subscribe { t -> println(t) }

        Observable.zip(
            Observable.just(
                "Joey", "Ross", "Chandler", "Monica", "Rachel", "Phoebe"
            ),
            Observable.just(
                "Barney", "Ted", "Marshall", "Lily", "Robin"
            ),
            Observable.just(
                1, 2, 3, 4, 5
            ),
            Observable.just(
                false, true, false, true, false, false
            ),
            Observable.just(
                false, true, false, true, false, false
            ),
            Function5<String, String, Int, Boolean, Boolean, String> { friend, himym, number, ok, ok2 ->
                "$friend $himym $number = $ok $ok2"
            }
        ).subscribe { t -> println(t) }
    }
}