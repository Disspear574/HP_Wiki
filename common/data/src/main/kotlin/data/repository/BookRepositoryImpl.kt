package data.repository

import data.datastore.BookDataSource
import domain.repository.BookRepository

class BookRepositoryImpl(
    private val storage: BookDataSource,
) : BookRepository {
    override suspend fun getAllBooks() = storage.getAllBooks().map { it.toDomain() }

    override suspend fun getBookById(id: Int) = storage.getBookById(id).toDomain()

    override suspend fun fetch() = storage.fetch()

    override fun clear() = storage.clear()
}
