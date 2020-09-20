package com.asefactory.typicodeexample.data.network

import com.asefactory.typicodeexample.data.db.entities.PostsCacheEntity
import io.reactivex.Single
import retrofit2.http.GET

interface NetworkInterface {

    @GET("posts")
    fun getPosts(): Single<List<PostsCacheEntity>>
}