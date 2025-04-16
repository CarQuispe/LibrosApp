package com.tuusuario.framework.mapper

import com.tuusuario.domain.Book
import com.tuusuario.framework.entity.BookEntity
import org.json.JSONArray

fun BookEntity.toBook(): Book {
    val authors = try {
        val jsonArray = JSONArray(authorNames)
        List(jsonArray.length()) { index -> jsonArray.getString(index) }
    } catch (e: Exception) {
        emptyList()
    }

    return Book(
        id = id,
        title = title,
        authorName = authors,
        firstPublishYear = firstPublishYear,
        coverId = coverId
    )
}