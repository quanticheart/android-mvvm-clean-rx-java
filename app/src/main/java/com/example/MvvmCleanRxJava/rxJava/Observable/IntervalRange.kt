package com.example.MvvmCleanRxJava.rxJava.Observable

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.MvvmCleanRxJava.R
import com.example.MvvmCleanRxJava.utils.MsgUtil
import io.reactivex.Observable
import java.util.concurrent.TimeUnit

class IntervalRange : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()

        /**
         * interval
         */

        /**
         * O método interval retorna um Observable que emite uma sequência crescente de
         * inteiros em um intervalo de tempo constante e configurável.
         */

        /**
         * Nesse exemplo, a emissão é feita a cada um segundo. Se você executar esse código na
         * classe de teste como foi mencionado no inicio do artigo, apenas o primeiro item será emitido.
         * Nesse caso você deverá adicionar um Thread.sleep(6_000) que fará com que o teste aguarde 6
         * segundos (1 a mais que o nosso Observable precisa.
         */

        getSimpleIntervalRange().subscribe(
            { result -> MsgUtil.log(result.toString()) },
            { e -> MsgUtil.log(e.message ?: "") },
            { MsgUtil.log("intervalRange Complete") }
        )
    }

    private fun getSimpleIntervalRange() =
        Observable.intervalRange(
            50L, // start
            11L, // count
            0L, // initial delay
            1L, // period
            TimeUnit.SECONDS
        )
}