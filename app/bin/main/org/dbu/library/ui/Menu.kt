package org.dbu.library.ui

fun showMenu(): String {

    println(
        """
        |================ LIBRARY MENU [for show]================
        | 1 | Add Book
        | 2 | Register Patron
        | 3 | Borrow Book
        | 4 | Return Book
        | 5 | Search
        | 6 | List All Books
        | 0 | Exit
        |==============================================
        | Enter option:
        """.trimMargin()
    )

    return readln().trim()
}