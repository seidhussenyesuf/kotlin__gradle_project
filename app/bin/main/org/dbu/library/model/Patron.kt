package org.dbu.library.model

data class Patron(
    val id: String,
    val name: String,
    val borrowedBooks: List<String> = emptyList()
)