package com.asefactory.typicodeexample.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class FavoritePostsEntity (
    @PrimaryKey val id: Long,
    @ColumnInfo(name = "user_id") val userId: String,
    val title: String,
    val body: String
)