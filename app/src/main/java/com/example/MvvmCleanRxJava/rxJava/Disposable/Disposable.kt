package com.example.MvvmCleanRxJava.rxJava.Disposable

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.MvvmCleanRxJava.R
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable

class Disposable : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /**
         * Disposable
         */

        /**
         * Ao realizar uma subscription em um Observable, uma instância de Disposable é retornada.
         * Isso permite liberar os recursos e threads alocadas para o Observer por meio do método dispose.
         */

        /**
         * Se estiver realizando várias subscriptions, podemos utilizar a classe CompositeDisposable,
         * adicionar os objetos Disposable a ele,
         * e liberar todos invocando o método clear. Isso é muito importante no Android para evitar
         * leaks de memória.
         */

    }

    override fun onResume() {
        super.onResume()
        val disposable = Observable.just("Hello").subscribe { println(it) }
        disposable.dispose()

        val obs1 = Observable.just("A").subscribe { println(it) }
        val obs2 = Observable.just("B").subscribe { println(it) }

        val compositeDisposable = CompositeDisposable()
        compositeDisposable.add(obs1)
        compositeDisposable.add(obs2)
        compositeDisposable.clear()
    }
}