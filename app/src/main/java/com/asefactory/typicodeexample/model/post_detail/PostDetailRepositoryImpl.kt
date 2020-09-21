package com.asefactory.typicodeexample.model.post_detail

import com.asefactory.typicodeexample.data.db.daos.FavoritePostsDao
import com.asefactory.typicodeexample.data.db.entities.FavoritePostsEntity
import io.reactivex.Completable
import io.reactivex.Single

import javax.inject.Inject

class PostDetailRepositoryImpl @Inject constructor(private val favorite: FavoritePostsDao):
    PostDetailRepository {
    override fun deleteFromFavorite(id: Long): Single<Int> {
        return favorite.delete(FavoritePostsEntity(id))
    }

    override fun addToFavorite(id: Long): Completable {
        return favorite.insert(FavoritePostsEntity(id))
    }

}