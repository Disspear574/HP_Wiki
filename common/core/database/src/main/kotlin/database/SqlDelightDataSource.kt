package database

import android.content.Context
import coil.ImageLoader
import coil.request.ImageRequest
import data.datastore.BookDataSource
import data.datastore.CharacterDataSource
import data.entity.BookEntity
import data.entity.CharacterEntity
import network.api.BooksApi
import network.api.CharactersApi
import ru.disspear574.database.HPDatabase

abstract class SqlDelightDataSource(
    private val imageLoader: ImageLoader,
    private val context: Context,
) {
    fun downloadImage(remoteUrl: String?) {
        val imageRequest = ImageRequest.Builder(context).data(remoteUrl).crossfade(true).build()
        imageLoader.enqueue(imageRequest)
    }
}

class BooksDataSourceImpl(
    db: HPDatabase,
    imageLoader: ImageLoader,
    context: Context,
    private val booksApi: BooksApi,
) : SqlDelightDataSource(imageLoader, context),
    BookDataSource {
    private val booksQueries = db.booksQueries

    override suspend fun getAllBooks(): List<BookEntity> =
        booksQueries.getAllBooks().executeAsList().map { it.toEntity() }

    override suspend fun getBookById(id: Int): BookEntity = booksQueries
        .getBookById(id.toLong())
        .executeAsOne()
        .toEntity()

    override suspend fun fetch(): Boolean {
        try {
            booksApi.getBooks().forEach { bookDto ->
                booksQueries.insert(bookDto.toEntity())
                downloadImage(bookDto.cover)
            }
            return true
        } catch (e: Exception) {
            println("error $e")
            return false
        }
    }

    override fun clear() {
        booksQueries.clear()
    }
}

class CharacterDataSourceImpl(
    db: HPDatabase,
    imageLoader: ImageLoader,
    context: Context,
    private val charactersApi: CharactersApi,
) : SqlDelightDataSource(imageLoader, context),
    CharacterDataSource {
    private val charactersQueries = db.charactersQueries

    override suspend fun getAll(): List<CharacterEntity> =
        charactersQueries.getAllCharacters().executeAsList().map {
            it.toEntity()
        }

    override suspend fun getById(id: Int): CharacterEntity = charactersQueries.getCharacterById(
        id.toLong()
    ).executeAsOne().toEntity()

    override suspend fun fetch(): Boolean {
        try {
            charactersApi.getCharacters().forEach { bookDto ->
                charactersQueries.insert(bookDto.toEntity())
                downloadImage(bookDto.image)
            }
            return true
        } catch (e: Exception) {
            println("error $e")
            return false
        }
    }

    override fun clear() {
        charactersQueries.clear()
    }
}
