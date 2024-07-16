package presentation.books.library

import androidx.compose.runtime.Stable
import domain.models.BookModel

@Stable
internal data class LibraryState(
    val booksList: List<BookModel> = emptyList(),
)
