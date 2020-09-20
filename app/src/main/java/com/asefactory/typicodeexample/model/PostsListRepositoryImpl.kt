package com.asefactory.typicodeexample.model

import com.asefactory.typicodeexample.data.db.daos.PostsCacheDao
import com.asefactory.typicodeexample.data.db.entities.PostsCacheEntity
import com.asefactory.typicodeexample.data.network.NetworkInterface
import io.reactivex.Single

import javax.inject.Inject

class PostsListRepositoryImpl @Inject constructor(private val api: NetworkInterface, private val cache: PostsCacheDao): PostsListRepository {

    override fun getPosts(): Single<List<PostsCacheEntity>> {
        return api
            .getPosts()
            .doAfterSuccess {
                cache.deleteAll()
                cache.insertAll(it)
            }
            .onErrorResumeNext {
                cache.getAll()
            }
    }
}