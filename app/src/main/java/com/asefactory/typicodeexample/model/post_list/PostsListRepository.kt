package com.asefactory.typicodeexample.model.post_list

import com.asefactory.typicodeexample.data.db.entities.PostsCacheEntity
import io.reactivex.Single

interface PostsListRepository {

    fun getPosts(): Single<List<PostsCacheEntity>>

}
