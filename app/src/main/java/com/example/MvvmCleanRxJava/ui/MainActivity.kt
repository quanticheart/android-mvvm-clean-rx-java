package com.example.mvvmCleanRxJava.ui

import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.mvvmCleanRxJava.R
import com.example.mvvmCleanRxJava.ui.adapter.NewsAdapter
import com.quanticheart.core.extentions.activity.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<MainActivityViewModel>() {

    /**
     * News Api
     * https://newsapi.org/docs/get-started
     *
     * https://cobe.tech/blog/post/developing-android-apps-with-kotlin-and-clean-architecture/
     *
     * map or flatmap
     * https://medium.com/@R00We/different-between-map-and-flatmap-in-rx-e4230355f17f
     */

    private lateinit var adapter: NewsAdapter

    override fun setLayoutContent(): Int = R.layout.activity_main

    override fun initLayout(savedInstanceState: Bundle?) {
        adapter = NewsAdapter(recycler_view)
    }

    override fun initViewModel(viewModel: MainActivityViewModel) {
        viewModel.getList().observe(this, Observer {
            adapter.addItens(it)
        })
        viewModel.connectionStatus.observe(this, Observer {
            it.connStatus()
        })
        viewModel.loading.observe(this, Observer {
            flipper.displayedChild = if (it) 0 else 1
        })
        viewModel.getNewsListFromWs()
    }

}