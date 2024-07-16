package network.impl

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import network.api.BooksApi
import network.model.Book

class BooksApiImpl(
    private val httpClient: HttpClient,
) : BooksApi {
    override suspend fun getBooks(): List<Book> = httpClient.get("https://potterapi-fedeperin.vercel.app/en/books").body()

    override suspend fun getBookDetailById(id: Int): Book {
        val list: List<Book> =
            httpClient.get("https://potterapi-fedeperin.vercel.app/en/books").body()
        return list[id]
    }
}
