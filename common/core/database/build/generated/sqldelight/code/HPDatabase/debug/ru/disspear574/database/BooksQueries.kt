package ru.disspear574.database

import app.cash.sqldelight.Query
import app.cash.sqldelight.TransacterImpl
import app.cash.sqldelight.db.QueryResult
import app.cash.sqldelight.db.SqlCursor
import app.cash.sqldelight.db.SqlDriver
import kotlin.Any
import kotlin.Long
import kotlin.String

public class BooksQueries(
  driver: SqlDriver,
) : TransacterImpl(driver) {
  public fun <T : Any> getAllBooks(mapper: (
    number: Long,
    title: String,
    original_title: String,
    release_date: String,
    description: String,
    pages: Long,
    cover: String,
    num: Long,
  ) -> T): Query<T> = Query(83_156_148, arrayOf("booksTable"), driver, "Books.sq", "getAllBooks",
      "SELECT * FROM booksTable") { cursor ->
    mapper(
      cursor.getLong(0)!!,
      cursor.getString(1)!!,
      cursor.getString(2)!!,
      cursor.getString(3)!!,
      cursor.getString(4)!!,
      cursor.getLong(5)!!,
      cursor.getString(6)!!,
      cursor.getLong(7)!!
    )
  }

  public fun getAllBooks(): Query<BooksTable> = getAllBooks { number, title, original_title,
      release_date, description, pages, cover, num ->
    BooksTable(
      number,
      title,
      original_title,
      release_date,
      description,
      pages,
      cover,
      num
    )
  }

  public fun <T : Any> getBookById(number: Long, mapper: (
    number: Long,
    title: String,
    original_title: String,
    release_date: String,
    description: String,
    pages: Long,
    cover: String,
    num: Long,
  ) -> T): Query<T> = GetBookByIdQuery(number) { cursor ->
    mapper(
      cursor.getLong(0)!!,
      cursor.getString(1)!!,
      cursor.getString(2)!!,
      cursor.getString(3)!!,
      cursor.getString(4)!!,
      cursor.getLong(5)!!,
      cursor.getString(6)!!,
      cursor.getLong(7)!!
    )
  }

  public fun getBookById(number: Long): Query<BooksTable> = getBookById(number) { number_, title,
      original_title, release_date, description, pages, cover, num ->
    BooksTable(
      number_,
      title,
      original_title,
      release_date,
      description,
      pages,
      cover,
      num
    )
  }

  public fun insert(booksTable: BooksTable) {
    driver.execute(-1_373_717_532, """
        |INSERT INTO booksTable(number, title, original_title, release_date, description, pages, cover, num)
        |VALUES (?, ?, ?, ?, ?, ?, ?, ?)
        """.trimMargin(), 8) {
          bindLong(0, booksTable.number)
          bindString(1, booksTable.title)
          bindString(2, booksTable.original_title)
          bindString(3, booksTable.release_date)
          bindString(4, booksTable.description)
          bindLong(5, booksTable.pages)
          bindString(6, booksTable.cover)
          bindLong(7, booksTable.num)
        }
    notifyQueries(-1_373_717_532) { emit ->
      emit("booksTable")
    }
  }

  public fun clear() {
    driver.execute(504_261_570, """DELETE FROM booksTable""", 0)
    notifyQueries(504_261_570) { emit ->
      emit("booksTable")
    }
  }

  private inner class GetBookByIdQuery<out T : Any>(
    public val number: Long,
    mapper: (SqlCursor) -> T,
  ) : Query<T>(mapper) {
    override fun addListener(listener: Query.Listener) {
      driver.addListener("booksTable", listener = listener)
    }

    override fun removeListener(listener: Query.Listener) {
      driver.removeListener("booksTable", listener = listener)
    }

    override fun <R> execute(mapper: (SqlCursor) -> QueryResult<R>): QueryResult<R> =
        driver.executeQuery(315_929_990, """SELECT * FROM booksTable WHERE number = ?""", mapper, 1)
        {
      bindLong(0, number)
    }

    override fun toString(): String = "Books.sq:getBookById"
  }
}
