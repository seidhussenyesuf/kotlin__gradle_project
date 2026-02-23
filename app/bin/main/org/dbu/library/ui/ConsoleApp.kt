package org.dbu.library.ui

import org.dbu.library.model.Book
import org.dbu.library.model.Patron
import org.dbu.library.repository.InMemoryLibraryRepository
import org.dbu.library.service.DefaultLibraryService


fun main() {

    val repository = InMemoryLibraryRepository()
    val service = DefaultLibraryService(repository)

    seedData(repository)

    var running = true

    while (running) {
        val choice = showMenu()
        running = handleMenuAction(choice, service, repository)
    }

    println("Goodbye 👋")
}

fun seedData(repository: InMemoryLibraryRepository) {

    repository.addBook(Book("1", "Clean Code", "Robert Martin", 2008))
    repository.addBook(Book("2", "Effective Java", "Joshua Bloch", 2018))

    repository.addPatron(Patron("P1", "Alice"))
}