package presentation.characters.library

sealed class LibrarySideEffect {
    data class ShowDetails(
        val id: Int,
    ) : LibrarySideEffect()
}
