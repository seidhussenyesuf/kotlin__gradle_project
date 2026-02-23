package org.dbu.library.repository

import org.dbu.library.model.Book
import org.dbu.library.model.Patron

class InMemoryLibraryRepository : LibraryRepository {

    private val books = mutableMapOf<String, Book>()
    private val patrons = mutableMapOf<String, Patron>()

    TODO: Implement the methods to manage books and patrons in memory
}