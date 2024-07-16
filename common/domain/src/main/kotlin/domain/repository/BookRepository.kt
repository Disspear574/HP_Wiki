package domain.repository

import domain.models.BookModel

interface BookRepository {
    suspend fun getAllBooks(): List<BookModel>

    suspend fun getBookById(id: Int): BookModel

    suspend fun fetch(): Boolean

    fun clear()
}
