package ru.disspear574.database.database

import app.cash.sqldelight.TransacterImpl
import app.cash.sqldelight.db.AfterVersion
import app.cash.sqldelight.db.QueryResult
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.db.SqlSchema
import kotlin.Long
import kotlin.Unit
import kotlin.reflect.KClass
import ru.disspear574.database.BooksQueries
import ru.disspear574.database.CharactersQueries
import ru.disspear574.database.CharactersTable
import ru.disspear574.database.HPDatabase

internal val KClass<HPDatabase>.schema: SqlSchema<QueryResult.Value<Unit>>
  get() = HPDatabaseImpl.Schema

internal fun KClass<HPDatabase>.newInstance(driver: SqlDriver,
    charactersTableAdapter: CharactersTable.Adapter): HPDatabase = HPDatabaseImpl(driver,
    charactersTableAdapter)

private class HPDatabaseImpl(
  driver: SqlDriver,
  charactersTableAdapter: CharactersTable.Adapter,
) : TransacterImpl(driver), HPDatabase {
  override val booksQueries: BooksQueries = BooksQueries(driver)

  override val charactersQueries: CharactersQueries = CharactersQueries(driver,
      charactersTableAdapter)

  public object Schema : SqlSchema<QueryResult.Value<Unit>> {
    override val version: Long
      get() = 1

    override fun create(driver: SqlDriver): QueryResult.Value<Unit> {
      driver.execute(null, """
          |CREATE TABLE booksTable (
          |  number INTEGER PRIMARY KEY NOT NULL,
          |  title TEXT NOT NULL,
          |  original_title TEXT NOT NULL,
          |  release_date TEXT NOT NULL,
          |  description TEXT NOT NULL,
          |  pages INTEGER NOT NULL,
          |  cover TEXT NOT NULL,
          |  num INTEGER NOT NULL
          |)
          """.trimMargin(), 0)
      driver.execute(null, """
          |CREATE TABLE charactersTable (
          |  full_name TEXT NOT NULL,
          |  nickname TEXT NOT NULL,
          |  hogwarts_house TEXT NOT NULL,
          |  interpreted_by TEXT NOT NULL,
          |  children TEXT NOT NULL,
          |  image TEXT NOT NULL,
          |  birthDay TEXT NOT NULL,
          |  num INTEGER NOT NULL
          |)
          """.trimMargin(), 0)
      return QueryResult.Unit
    }

    override fun migrate(
      driver: SqlDriver,
      oldVersion: Long,
      newVersion: Long,
      vararg callbacks: AfterVersion,
    ): QueryResult.Value<Unit> = QueryResult.Unit
  }
}
