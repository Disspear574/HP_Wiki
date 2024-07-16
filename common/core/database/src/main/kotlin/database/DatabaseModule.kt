package database

import app.cash.sqldelight.db.SqlDriver
import data.datastore.BookDataSource
import data.datastore.CharacterDataSource
import org.koin.dsl.module
import ru.disspear574.database.CharactersTable
import ru.disspear574.database.HPDatabase

val databaseModule =
    module {

        single<SqlDriver> {
            DatabaseDriverFactory(get()).createDriver()
        }

        single<HPDatabase> {
            HPDatabase(
                driver = get(),
                charactersTableAdapter =
                    CharactersTable.Adapter(
                        listOfStringsAdapter,
                    ),
            )
        }

        single<BookDataSource> {
            BooksDataSourceImpl(
                db = get(),
                imageLoader = get(),
                context = get(),
                booksApi = get(),
            )
        }

        single<CharacterDataSource> {
            CharacterDataSourceImpl(
                db = get(),
                imageLoader = get(),
                context = get(),
                charactersApi = get(),
            )
        }
    }
