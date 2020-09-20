package com.asefactory.typicodeexample.data.db.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.asefactory.typicodeexample.data.db.entities.PostsCacheEntity
import io.reactivex.Maybe
import io.reactivex.Single

@Dao
interface PostsCacheDao {

    @Query("SELECT * FROM PostsCacheEntity")
    fun getAll(): Single<List<PostsCacheEntity>>

    @Insert
    fun insertAll( posts: List<PostsCacheEntity>)

    @Query("DELETE FROM PostsCacheEntity")
    fun deleteAll()
}