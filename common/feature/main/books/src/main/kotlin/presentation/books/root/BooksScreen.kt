package presentation.books.root

import kotlinx.serialization.Serializable

@Serializable
sealed class BooksScreen {
    @Serializable
    data object BooksLibrary : BooksScreen()

    @Serializable
    data class BookDetail(
        val bookId: Int,
    ) : BooksScreen()
}
