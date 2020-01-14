package com.quanticheart.model.repository.posts

import com.quanticheart.domain.base.Result
import com.quanticheart.domain.model.Posts
import com.quanticheart.domain.repository.PostsRepository
import com.quanticheart.model.extentions.defaultConfig
import com.quanticheart.model.networking.endpoint.EndpointPosts
import com.quanticheart.model.networking.endpoint.Repository
import com.quanticheart.model.repository.posts.entitys.ResponsePosts
import io.reactivex.SingleObserver
import io.reactivex.disposables.Disposable

class PostsRepositoryImpl(private val api: EndpointPosts) : PostsRepository {
    /**
     * This site for get new ApiToken
     *
     * https://gorest.co.in/rest-console.html
     */
    override suspend fun getPosts(): Result<List<Posts>>? {
        Repository.getPostsConection().getPosts()
            .defaultConfig()
            .subscribe(object :
                SingleObserver<ResponsePosts> {
                override fun onSuccess(t: ResponsePosts) {
                    return t.result
                }

                override fun onSubscribe(d: Disposable) {
                    return null
                }

                override fun onError(e: Throwable) {
                    return null
                }
            })
    }
}

