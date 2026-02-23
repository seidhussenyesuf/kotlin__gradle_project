package org.dbu.library.ui

import org.dbu.library.model.Book
import org.dbu.library.model.Patron
import org.dbu.library.repository.LibraryRepository
import org.dbu.library.service.BorrowResult
import org.dbu.library.service.LibraryService

fun handleMenuAction(choice: String, service: LibraryService, repository: LibraryRepository): Boolean {
    return when (choice) {
        "1" -> {
            addBook(service)
            true
        }
        "2" -> {
            registerPatron(repository)
            true
        }
        "3" -> {
            borrowBook(service)
            true
        }
        "4" -> {
            returnBook(service)
            true
        }
        "5" -> {
            search(service)
            true
        }
        "6" -> {
            listAllBooks(repository)
            true
        }
        "0" -> false
        else -> {
            println("Invalid option")
            true
        }
    }
}

// ---------- ADD BOOK ----------
fun addBook(service: LibraryService) {
    println("Enter book ISBN:")
    val isbn = readln().trim()

    println("Enter title:")
    val title = readln().trim()

    println("Enter author:")
    val author = readln().trim()

    println("Enter year:")
    val year = readln().trim().toIntOrNull() ?: 2024

    val book = Book(isbn, title, author, year)
    service.addBook(book)

    println("Book added successfully!")
}

// ---------- REGISTER PATRON ----------
fun registerPatron(repository: LibraryRepository) {
    println("Enter patron id:")
    val id = readln().trim()

    println("Enter patron name:")
    val name = readln().trim()

    val patron = Patron(id, name)
    repository.addPatron(patron)

    println("Patron registered!")
}

// ---------- BORROW BOOK ----------
fun borrowBook(service: LibraryService) {
    println("Enter patron id:")
    val patronId = readln().trim()

    println("Enter book ISBN:")
    val isbn = readln().trim()

    val result = service.borrowBook(patronId, isbn)

    when (result) {
        BorrowResult.SUCCESS -> println("Book borrowed successfully")
        BorrowResult.BOOK_NOT_FOUND -> println("Book not found")
        BorrowResult.PATRON_NOT_FOUND -> println("Patron not found")
        BorrowResult.NOT_AVAILABLE -> println("Book is not available")
        BorrowResult.LIMIT_REACHED -> println("Patron has reached borrowing limit")
    }
}

// ---------- RETURN BOOK ----------
fun returnBook(service: LibraryService) {
    println("Enter patron id:")
    val patronId = readln().trim()

    println("Enter book ISBN:")
    val isbn = readln().trim()

    val result = service.returnBook(patronId, isbn)
    if (result) {
        println("Book returned successfully!")
    } else {
        println("Failed to return book")
    }
}

// ---------- SEARCH ----------
fun search(service: LibraryService) {
    println("Enter keyword:")
    val keyword = readln().trim()

    val results = service.search(keyword)

    if (results.isEmpty()) {
        println("No books found")
    } else {
        results.forEach { 
            println("${it.title} by ${it.author} (${it.year}) - ${if (it.isAvailable) "Available" else "Borrowed"}")
        }
    }
}

// ---------- LIST ALL BOOKS ----------
fun listAllBooks(repository: LibraryRepository) {
    val books = repository.getAllBooks()

    if (books.isEmpty()) {
        println("No books available")
    } else {
        books.forEach { 
            println("${it.title} by ${it.author} (${it.year}) - ${if (it.isAvailable) "Available" else "Borrowed"}")
        }
    }
}