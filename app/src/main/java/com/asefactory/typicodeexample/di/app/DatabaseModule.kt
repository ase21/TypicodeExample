package com.asefactory.typicodeexample.di.app

import android.content.Context
import androidx.room.Room
import com.asefactory.typicodeexample.data.db.AppDatabase
import com.asefactory.typicodeexample.data.db.daos.FavoritePostsDao
import com.asefactory.typicodeexample.data.db.daos.PostsCacheDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabaseService(context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "db").build()
    }

    @Singleton
    @Provides
    fun providePostsCacheDao(database: AppDatabase): PostsCacheDao {
        return database.postsCacheDao()
    }

    @Singleton
    @Provides
    fun provideCacheTablesDao(database: AppDatabase): FavoritePostsDao {
        return database.favoritePostsDao()
    }
}
