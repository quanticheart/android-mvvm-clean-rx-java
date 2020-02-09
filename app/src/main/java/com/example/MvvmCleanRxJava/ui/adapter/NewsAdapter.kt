package com.example.mvvmCleanRxJava.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmCleanRxJava.R
import com.quanticheart.domain.model.News
import kotlinx.android.synthetic.main.item_news.view.*

class NewsAdapter(private val recyclerView: RecyclerView) :
    RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    private var database: ArrayList<News> = ArrayList()

    init {
        recyclerView.apply {
            layoutManager = LinearLayoutManager(recyclerView.context, RecyclerView.VERTICAL, false)
            adapter = this@NewsAdapter
        }
    }

    fun addItens(list: List<News>) {
        if (list.isNotEmpty()) {
            database.addAll(list)
            notifyDataSetChanged()
        }
    }

    class NewsViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        fun bindView(news: News) {
            view.itemNewsImg
            view.itemNewsTitle.text = news.title
            view.itemNewsBtn.setOnClickListener {
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder =
        NewsViewHolder(
            LayoutInflater.from(recyclerView.context).inflate(
                R.layout.item_news, parent, false
            )
        )

    override fun getItemCount(): Int = database.size

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bindView(database[position])
    }
}