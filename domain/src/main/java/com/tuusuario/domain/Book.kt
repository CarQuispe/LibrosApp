package com.tuusuario.domain



data class Book(
    val id: String,
    val title: String,
    val authorName: String,
    val firstPublishYear: Int?,
    val coverId: Int?
)