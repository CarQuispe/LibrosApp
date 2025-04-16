package com.tuusuario.framework.database

import androidx.room.*
import com.tuusuario.framework.entity.BookEntity

@Dao
interface BookDao {
    @Query("SELECT * FROM favorite_books")
    suspend fun getAll(): List<BookEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(book: BookEntity)

    @Delete
    suspend fun delete(book: BookEntity)

    @Query("SELECT * FROM favorite_books WHERE id = :bookId")
    suspend fun getById(bookId: String): BookEntity?

    @Query("SELECT EXISTS(SELECT * FROM favorite_books WHERE id = :bookId)")
    suspend fun isFavorite(bookId: String): Boolean
}