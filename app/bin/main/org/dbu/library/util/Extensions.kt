package org.dbu.library.util

import org.dbu.library.model.Book

fun Book.display(): String =
    "$title by $author ($year)"