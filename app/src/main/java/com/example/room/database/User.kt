package com.example.room.database

class User(
    user_id: String,
    user_name: String,
) {
    val user_id: String = user_id
    val user_name: String = user_name
}

fun User.toEntity() = UserEntity(
    user_id,
    user_name
)