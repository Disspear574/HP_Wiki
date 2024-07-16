package presentation.books.library

internal sealed class LibrarySideEffect {
    data class ShowDetails(
        val id: Int,
    ) : LibrarySideEffect()
}
