package com.tuusuario.data.datasource

import com.tuusuario.domain.Book

interface LocalBookDataSource {
    suspend fun getFavorites(): List<Book>
    suspend fun addFavorite(book: Book)
    suspend fun removeFavorite(bookId: String)
    abstract fun isFavorite(id: String): Boolean
}
