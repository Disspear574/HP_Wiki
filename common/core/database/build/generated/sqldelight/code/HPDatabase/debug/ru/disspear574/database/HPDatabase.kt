package ru.disspear574.database

import app.cash.sqldelight.Transacter
import app.cash.sqldelight.db.QueryResult
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.db.SqlSchema
import kotlin.Unit
import ru.disspear574.database.database.newInstance
import ru.disspear574.database.database.schema

public interface HPDatabase : Transacter {
  public val booksQueries: BooksQueries

  public val charactersQueries: CharactersQueries

  public companion object {
    public val Schema: SqlSchema<QueryResult.Value<Unit>>
      get() = HPDatabase::class.schema

    public operator fun invoke(driver: SqlDriver, charactersTableAdapter: CharactersTable.Adapter):
        HPDatabase = HPDatabase::class.newInstance(driver, charactersTableAdapter)
  }
}
