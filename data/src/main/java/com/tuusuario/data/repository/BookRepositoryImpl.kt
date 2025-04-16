package com.tuusuario.data.repository

import com.tuusuario.data.datasource.LocalBookDataSource
import com.tuusuario.data.datasource.RemoteBookDataSource
import com.tuusuario.domain.Book
import com.tuusuario.domain.BookRepository
import kotlinx.coroutines.flow.Flow

class BookRepositoryImpl(
    private val remoteDataSource: RemoteBookDataSource,
    private val localDataSource: LocalBookDataSource
) : BookRepository {

    override suspend fun searchBooks(query: String): List<Book> {
        val bookDtos = remoteDataSource.searchBooks(query)
        val books = mutableListOf<Book>()
        for (dto in bookDtos) {
           // books.add(dto.toBook())
        }
        return books
    }

    override suspend fun getFavoriteBooks(): List<Book> {

        return localDataSource.getFavorites()
    }

    override suspend fun addFavorite(book: Book) {
        localDataSource.addFavorite(book)
    }

    override suspend fun removeFavorite(bookId: String) {
        localDataSource.removeFavorite(bookId)
    }

    suspend fun isFavorite(bookId: String): Boolean {
        return localDataSource.isFavorite(bookId)
    }
}