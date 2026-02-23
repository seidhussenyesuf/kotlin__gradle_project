package org.dbu.library.repository

import org.dbu.library.model.Book
import org.dbu.library.model.Patron

class InMemoryLibraryRepository : LibraryRepository {  // Make sure it implements the interface

    private val books = mutableListOf<Book>()
    private val patrons = mutableListOf<Patron>()

    override fun addBook(book: Book): Boolean {
        books.add(book)
        return true
    }

    override fun findBook(isbn: String): Book? {
        return books.find { it.isbn == isbn }
    }

    override fun updateBook(book: Book) {
        val index = books.indexOfFirst { it.isbn == book.isbn }
        if (index != -1) books[index] = book
    }

    override fun addPatron(patron: Patron): Boolean {
        patrons.add(patron)
        return true
    }

    override fun findPatron(id: String): Patron? {
        return patrons.find { it.id == id }
    }

    override fun updatePatron(patron: Patron) {
        val index = patrons.indexOfFirst { it.id == patron.id }
        if (index != -1) patrons[index] = patron
    }

    override fun getAllBooks(): List<Book> {
        return books
    }
}