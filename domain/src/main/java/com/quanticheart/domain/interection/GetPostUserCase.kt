package com.quanticheart.domain.interection

import com.quanticheart.domain.base.Result
import com.quanticheart.domain.model.Posts

interface GetPostUserCase {
    suspend fun getPosts(): Result<List<Posts>>
}