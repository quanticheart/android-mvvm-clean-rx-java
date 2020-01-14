package com.quanticheart.domain.repository

import com.quanticheart.domain.model.Posts
import com.quanticheart.domain.base.Result

interface PostsRepository {
    suspend fun getPosts(): Result<List<Posts>>
}