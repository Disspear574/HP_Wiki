package data.datastore

import data.entity.BookEntity

interface BookDataSource {
    suspend fun getAllBooks(): List<BookEntity>

    suspend fun getBookById(id: Int): BookEntity

    suspend fun fetch(): Boolean

    fun clear()
}
