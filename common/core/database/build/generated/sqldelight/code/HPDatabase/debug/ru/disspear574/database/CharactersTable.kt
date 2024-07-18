package ru.disspear574.database

import app.cash.sqldelight.ColumnAdapter
import kotlin.Long
import kotlin.String
import kotlin.collections.List

public data class CharactersTable(
  public val full_name: String,
  public val nickname: String,
  public val hogwarts_house: String,
  public val interpreted_by: String,
  public val children: List<String>,
  public val image: String,
  public val birthDay: String,
  public val num: Long,
) {
  public class Adapter(
    public val childrenAdapter: ColumnAdapter<List<String>, String>,
  )
}
