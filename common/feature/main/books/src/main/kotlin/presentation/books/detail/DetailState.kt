package presentation.books.detail

import domain.models.BookModel

internal data class DetailState(
    val book: BookModel = BookModel.empty,
)
