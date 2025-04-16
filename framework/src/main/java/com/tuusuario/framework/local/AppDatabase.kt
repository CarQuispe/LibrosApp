package com.tuusuario.framework.local

import androidx.room.Database
import androidx.room.RoomDatabase

import com.tuusuario.data.datasource.LocalBookDataSource
import com.tuusuario.domain.Book
import com.tuusuario.framework.database.BookDao
import com.tuusuario.framework.entity.BookEntity

//import kotlinx.serialization.json.Json

@Database(
    entities = [BookEntity::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun bookDao(): BookDao
}
