package com.example.MvvmCleanRxJava

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.quanticheart.model.repository.posts.PostsRepositoryImpl

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        PostsRepositoryImpl.getPost()
    }
}