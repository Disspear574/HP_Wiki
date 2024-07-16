package data.entity

import domain.models.BookModel
import kotlinx.serialization.Serializable

@Serializable
data class BookEntity(
    val number: Int,
    val title: String,
    val originalTitle: String,
    val releaseDate: String,
    val description: String,
    val pages: Int,
    val cover: String,
    val index: Int,
) {
    fun toDomain(): BookModel =
        BookModel(
            number = number,
            title = title,
            originalTitle = originalTitle,
            releaseDate = releaseDate,
            description = description,
            pages = pages,
            cover = cover,
            index = index,
        )
}
