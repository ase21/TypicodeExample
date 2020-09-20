package com.asefactory.typicodeexample.model.post_detail

import com.asefactory.typicodeexample.data.db.daos.FavoritePostsDao
import com.asefactory.typicodeexample.data.db.daos.PostsCacheDao
import com.asefactory.typicodeexample.data.db.entities.FavoritePostsEntity
import com.asefactory.typicodeexample.data.db.entities.PostsCacheEntity
import com.asefactory.typicodeexample.data.network.NetworkInterface
import io.reactivex.Single

import javax.inject.Inject

class PostDetailRepositoryImpl @Inject constructor(private val cache: PostsCacheDao, private val favorite: FavoritePostsDao):
    PostDetailRepository {

}