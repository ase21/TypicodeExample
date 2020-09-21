package com.asefactory.typicodeexample.model.post_detail

import io.reactivex.Completable
import io.reactivex.Single

interface PostDetailRepository {

    fun deleteFromFavorite(id: Long): Single<Int>

    fun addToFavorite(id: Long): Completable
}
