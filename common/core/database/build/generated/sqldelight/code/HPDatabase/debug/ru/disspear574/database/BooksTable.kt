package ru.disspear574.database

import kotlin.Long
import kotlin.String

public data class BooksTable(
  public val number: Long,
  public val title: String,
  public val original_title: String,
  public val release_date: String,
  public val description: String,
  public val pages: Long,
  public val cover: String,
  public val num: Long,
)
