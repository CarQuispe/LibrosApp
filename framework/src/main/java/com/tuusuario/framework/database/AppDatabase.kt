package com.tuusuario.framework.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.tuusuario.framework.entity.BookEntity

@Database(
    entities = [BookEntity::class],
    version = 1,
    exportSchema = false  // Opcional (evita generar schemas en desarrollo)
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun bookDao(): BookDao

    companion object {
        const val DATABASE_NAME = "bookfinder_db"
    }
}