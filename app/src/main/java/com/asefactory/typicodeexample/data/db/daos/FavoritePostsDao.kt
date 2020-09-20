package com.asefactory.typicodeexample.data.db.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.asefactory.typicodeexample.data.db.entities.FavoritePostsEntity
import io.reactivex.Single

@Dao
interface FavoritePostsDao {

    @Query("SELECT * FROM FavoritePostsEntity")
    fun getAll(): Single<List<FavoritePostsEntity>>

    @Insert
    fun insert(post: FavoritePostsEntity)

    @Delete
    fun delete(post: FavoritePostsEntity)
}