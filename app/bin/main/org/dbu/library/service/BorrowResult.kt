package org.dbu.library.service

enum class BorrowResult {
    SUCCESS,
    BOOK_NOT_FOUND,
    PATRON_NOT_FOUND,
    NOT_AVAILABLE,
    LIMIT_REACHED
}