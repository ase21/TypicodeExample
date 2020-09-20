package com.asefactory.typicodeexample.data.db.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.asefactory.typicodeexample.data.db.entities.FavoritePostsEntity

@Dao
interface FavoritePostsDao {

    @Query("SELECT * FROM FavoritePostsEntity")
    fun getAll(): LiveData<List<FavoritePostsEntity>>

    @Query("SELECT * FROM FavoritePostsEntity WHERE id = :id")
    fun getById(id: Int): LiveData<List<FavoritePostsEntity>>

    @Insert
    fun insert(post: FavoritePostsEntity)

    @Delete
    fun delete(post: FavoritePostsEntity)
}