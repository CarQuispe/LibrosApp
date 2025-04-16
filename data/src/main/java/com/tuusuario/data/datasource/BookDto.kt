package com.tuusuario.data.datasource

import com.tuusuario.domain.Book

data class BookDto(
    val key: String,
    val title: String,
    val authorNames: List<String>?,
    val firstPublishYear: Int?,  // Cambié el nombre a firstPublishYear
    val coverId: Int?  // Cambié el nombre a coverId
) {


}

