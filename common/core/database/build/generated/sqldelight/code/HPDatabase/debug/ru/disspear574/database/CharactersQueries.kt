package ru.disspear574.database

import app.cash.sqldelight.Query
import app.cash.sqldelight.TransacterImpl
import app.cash.sqldelight.db.QueryResult
import app.cash.sqldelight.db.SqlCursor
import app.cash.sqldelight.db.SqlDriver
import kotlin.Any
import kotlin.Long
import kotlin.String
import kotlin.collections.List

public class CharactersQueries(
  driver: SqlDriver,
  private val charactersTableAdapter: CharactersTable.Adapter,
) : TransacterImpl(driver) {
  public fun <T : Any> getAllCharacters(mapper: (
    full_name: String,
    nickname: String,
    hogwarts_house: String,
    interpreted_by: String,
    children: List<String>,
    image: String,
    birthDay: String,
    num: Long,
  ) -> T): Query<T> = Query(1_420_078_106, arrayOf("charactersTable"), driver, "Characters.sq",
      "getAllCharacters", "SELECT * FROM charactersTable") { cursor ->
    mapper(
      cursor.getString(0)!!,
      cursor.getString(1)!!,
      cursor.getString(2)!!,
      cursor.getString(3)!!,
      charactersTableAdapter.childrenAdapter.decode(cursor.getString(4)!!),
      cursor.getString(5)!!,
      cursor.getString(6)!!,
      cursor.getLong(7)!!
    )
  }

  public fun getAllCharacters(): Query<CharactersTable> = getAllCharacters { full_name, nickname,
      hogwarts_house, interpreted_by, children, image, birthDay, num ->
    CharactersTable(
      full_name,
      nickname,
      hogwarts_house,
      interpreted_by,
      children,
      image,
      birthDay,
      num
    )
  }

  public fun <T : Any> getCharacterById(num: Long, mapper: (
    full_name: String,
    nickname: String,
    hogwarts_house: String,
    interpreted_by: String,
    children: List<String>,
    image: String,
    birthDay: String,
    num: Long,
  ) -> T): Query<T> = GetCharacterByIdQuery(num) { cursor ->
    mapper(
      cursor.getString(0)!!,
      cursor.getString(1)!!,
      cursor.getString(2)!!,
      cursor.getString(3)!!,
      charactersTableAdapter.childrenAdapter.decode(cursor.getString(4)!!),
      cursor.getString(5)!!,
      cursor.getString(6)!!,
      cursor.getLong(7)!!
    )
  }

  public fun getCharacterById(num: Long): Query<CharactersTable> = getCharacterById(num) {
      full_name, nickname, hogwarts_house, interpreted_by, children, image, birthDay, num_ ->
    CharactersTable(
      full_name,
      nickname,
      hogwarts_house,
      interpreted_by,
      children,
      image,
      birthDay,
      num_
    )
  }

  public fun insert(charactersTable: CharactersTable) {
    driver.execute(-275_353_122, """
        |INSERT INTO charactersTable(full_name, nickname, hogwarts_house, interpreted_by, children, image, birthDay, num)
        |VALUES (?, ?, ?, ?, ?, ?, ?, ?)
        """.trimMargin(), 8) {
          bindString(0, charactersTable.full_name)
          bindString(1, charactersTable.nickname)
          bindString(2, charactersTable.hogwarts_house)
          bindString(3, charactersTable.interpreted_by)
          bindString(4, charactersTableAdapter.childrenAdapter.encode(charactersTable.children))
          bindString(5, charactersTable.image)
          bindString(6, charactersTable.birthDay)
          bindLong(7, charactersTable.num)
        }
    notifyQueries(-275_353_122) { emit ->
      emit("charactersTable")
    }
  }

  public fun clear() {
    driver.execute(539_692_680, """DELETE FROM charactersTable""", 0)
    notifyQueries(539_692_680) { emit ->
      emit("charactersTable")
    }
  }

  private inner class GetCharacterByIdQuery<out T : Any>(
    public val num: Long,
    mapper: (SqlCursor) -> T,
  ) : Query<T>(mapper) {
    override fun addListener(listener: Query.Listener) {
      driver.addListener("charactersTable", listener = listener)
    }

    override fun removeListener(listener: Query.Listener) {
      driver.removeListener("charactersTable", listener = listener)
    }

    override fun <R> execute(mapper: (SqlCursor) -> QueryResult<R>): QueryResult<R> =
        driver.executeQuery(-1_177_792_566, """SELECT * FROM charactersTable WHERE num = ?""",
        mapper, 1) {
      bindLong(0, num)
    }

    override fun toString(): String = "Characters.sq:getCharacterById"
  }
}
