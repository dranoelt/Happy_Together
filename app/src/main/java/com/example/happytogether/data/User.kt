package com.example.happytogether.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class User(
    @PrimaryKey @ColumnInfo (name = "id") val userId: String,
    val name: String,
    val email: String,
    val password: String,
)
