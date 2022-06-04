package com.example.room.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = TABLE_USERS)
data class UserEntity(
    @ColumnInfo(name = "user_id") @PrimaryKey val uuid: String,
    @ColumnInfo(name = "user_name") val name: String
)

fun UserEntity.toUser() = User(
    uuid,
    name
)