package com.asefactory.typicodeexample.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.asefactory.typicodeexample.data.db.daos.FavoritePostsDao
import com.asefactory.typicodeexample.data.db.daos.PostsCacheDao
import com.asefactory.typicodeexample.data.db.entities.FavoritePostsEntity
import com.asefactory.typicodeexample.data.db.entities.PostsCacheEntity

@Database(entities = [PostsCacheEntity::class, FavoritePostsEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun postsCacheDao() : PostsCacheDao

    abstract fun favoritePostsDao() : FavoritePostsDao

}