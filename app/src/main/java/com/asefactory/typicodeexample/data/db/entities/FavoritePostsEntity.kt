package com.asefactory.typicodeexample.data.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class FavoritePostsEntity (
    @PrimaryKey val id: Long
)