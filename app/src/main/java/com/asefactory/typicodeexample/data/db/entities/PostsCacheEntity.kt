package com.asefactory.typicodeexample.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class PostsCacheEntity (
    @PrimaryKey val id: Long,
    @ColumnInfo(name = "user_id") val userId: String,
    val title: String,
    val body: String
) :Serializable{
    @Ignore
    var favorite: Boolean = false
}