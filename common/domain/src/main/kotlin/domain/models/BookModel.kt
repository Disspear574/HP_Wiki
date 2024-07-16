package domain.models

import androidx.compose.runtime.Immutable

@Immutable
data class BookModel(
    val number: Int,
    val title: String,
    val originalTitle: String,
    val releaseDate: String,
    val description: String,
    val pages: Int,
    val cover: String,
    val index: Int,
) {
    companion object {
        val empty =
            BookModel(
                index = 0,
                number = 0,
                description = "",
                pages = 0,
                title = "",
                originalTitle = "",
                cover = "",
                releaseDate = "",
            )
    }
}
