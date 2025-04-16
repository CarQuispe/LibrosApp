package com.tuusuario.domain

interface BookRepository {
    suspend fun searchBooks(query: String): List<Book>
    suspend fun getFavoriteBooks(): List<Book>
    suspend fun addFavorite(book: Book)
    suspend fun removeFavorite(bookId: String)
}