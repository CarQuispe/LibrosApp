package com.tuusuario.framework.local

import com.tuusuario.data.datasource.LocalBookDataSource
import com.tuusuario.domain.Book
import com.tuusuario.framework.database.BookDao
import com.tuusuario.framework.entity.toBook
import com.tuusuario.framework.entity.toEntity

class LocalBookDataSourceImpl(
    private val bookDao: BookDao
) : LocalBookDataSource {

    override suspend fun getFavorites(): List<Book> {
        return bookDao.getAll().map { it.toBook() }
    }

    override suspend fun addFavorite(book: Book) {
        bookDao.insert(book.toEntity())
    }

    override suspend fun removeFavorite(bookId: String) {
        val entity = bookDao.getAll().find { it.id == bookId }
        entity?.let { bookDao.delete(it) }
    }
}
