package org.dbu.library.model

data class Book(
    val isbn: String,
    val title: String,
    val author: String,
    val year: Int,
    val isAvailable: Boolean = true
)