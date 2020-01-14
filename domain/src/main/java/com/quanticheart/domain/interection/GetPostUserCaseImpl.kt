package com.quanticheart.domain.interection

import com.quanticheart.domain.base.Result
import com.quanticheart.domain.model.Posts
import com.quanticheart.domain.repository.PostsRepository

class GetPostUserCaseImpl(private val repository: PostsRepository) : GetPostUserCase {
    override suspend fun getPosts(): Result<List<Posts>> = repository.getPosts()
}