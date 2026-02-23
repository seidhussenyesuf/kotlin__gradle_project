package org.dbu.library.service

import org.dbu.library.model.Book
import org.dbu.library.repository.LibraryRepository  // Use interface, not concrete class

class DefaultLibraryService(
    private val repository: LibraryRepository  // Use interface
) : LibraryService {  // Implement the interface

    override fun addBook(book: Book): Boolean {
        return repository.addBook(book)
    }

    override fun borrowBook(patronId: String, isbn: String): BorrowResult {
        val book = repository.findBook(isbn)
        if (book == null) {
            return BorrowResult.BOOK_NOT_FOUND
        }
        
        val patron = repository.findPatron(patronId)
        if (patron == null) {
            return BorrowResult.PATRON_NOT_FOUND
        }
        
        if (!book.isAvailable) {
            return BorrowResult.NOT_AVAILABLE
        }
        
        if (patron.borrowedBooks.size >= 5) { // Assuming limit is 5
            return BorrowResult.LIMIT_REACHED
        }
        
        // Update book availability
        val updatedBook = book.copy(isAvailable = false)
        repository.updateBook(updatedBook)
        
        // Update patron's borrowed books
        val updatedPatron = patron.copy(
            borrowedBooks = patron.borrowedBooks + isbn
        )
        repository.updatePatron(updatedPatron)
        
        return BorrowResult.SUCCESS
    }

    override fun returnBook(patronId: String, isbn: String): Boolean {
        val book = repository.findBook(isbn)
        val patron = repository.findPatron(patronId)
        
        if (book != null && patron != null && !book.isAvailable) {
            // Update book availability
            val updatedBook = book.copy(isAvailable = true)
            repository.updateBook(updatedBook)
            
            // Update patron's borrowed books
            val updatedPatron = patron.copy(
                borrowedBooks = patron.borrowedBooks.filter { it != isbn }
            )
            repository.updatePatron(updatedPatron)
            
            return true
        }
        return false
    }

    override fun search(query: String): List<Book> {
        return repository.getAllBooks().filter { book ->
            book.title.contains(query, ignoreCase = true) ||
            book.author.contains(query, ignoreCase = true) ||
            book.isbn.contains(query, ignoreCase = true)
        }
    }

    fun listAllBooks(): List<Book> {
        return repository.getAllBooks()
    }
}