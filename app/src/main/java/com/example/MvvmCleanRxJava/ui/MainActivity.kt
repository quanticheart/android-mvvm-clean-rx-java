package com.example.mvvmCleanRxJava.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.mvvmCleanRxJava.R
import com.example.mvvmCleanRxJava.ui.adapter.NewsAdapter
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    /**
     * News Api
     * https://newsapi.org/docs/get-started
     *
     * https://cobe.tech/blog/post/developing-android-apps-with-kotlin-and-clean-architecture/
     */

    private val viewModel: MainActivityViewModel by viewModel()
    lateinit var adapter: NewsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initLayout()
        initViewModel()

    }

    private fun initLayout() {
        adapter = NewsAdapter(recycler_view)
    }

    private fun initViewModel() {
        viewModel.getList().observe(this, Observer {
            adapter.addItens(it)
            flipper.displayedChild = 1
        })
        viewModel.getNewsListFromWs()
    }
}