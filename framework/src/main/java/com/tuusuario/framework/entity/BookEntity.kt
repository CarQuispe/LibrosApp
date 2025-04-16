package com.tuusuario.framework.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorite_books")
data class BookEntity(
    @PrimaryKey
    val id: String,
    val title: String,
    val authorNames: String, // JSON serializado
    val firstPublishYear: Int?,
    val coverId: Int?
)

