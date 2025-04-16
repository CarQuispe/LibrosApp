package com.tuusuario.domain

import kotlinx.serialization.Serializable

@Serializable
data class Libro(
    val title: String,
    val posterPath: String,
    val overview: String
)