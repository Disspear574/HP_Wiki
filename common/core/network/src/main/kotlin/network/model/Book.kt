package network.model

import kotlinx.serialization.Serializable

@Serializable
data class Book(
    val number: Int,
    val title: String,
    val originalTitle: String,
    val releaseDate: String,
    val description: String,
    val pages: Int,
    val cover: String,
    val index: Int,
)
