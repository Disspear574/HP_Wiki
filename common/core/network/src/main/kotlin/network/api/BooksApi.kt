package network.api

import network.model.Book

interface BooksApi {
    suspend fun getBooks(): List<Book>

    suspend fun getBookDetailById(id: Int): Book
}
