package database

import data.entity.BookEntity
import data.entity.CharacterEntity
import network.model.Book
import network.model.Character
import ru.disspear574.database.BooksTable
import ru.disspear574.database.CharactersTable

fun BooksTable.toEntity(): BookEntity =
    BookEntity(
        number = number.toInt(),
        title = title,
        originalTitle = original_title,
        releaseDate = release_date,
        description = description,
        pages = pages.toInt(),
        cover = cover,
        index = num.toInt(),
    )

fun Book.toEntity(): BooksTable =
    BooksTable(
        number = number.toLong(),
        title = title,
        original_title = originalTitle,
        release_date = releaseDate,
        description = description,
        pages = pages.toLong(),
        cover = cover,
        num = index.toLong(),
    )

fun CharactersTable.toEntity(): CharacterEntity =
    CharacterEntity(
        fullName = full_name,
        nickName = nickname,
        hogwartsHouse = hogwarts_house,
        interpretedBy = interpreted_by,
        children = children,
        image = image,
        birthDay = birthDay,
        index = num.toInt(),
    )

fun Character.toEntity(): CharactersTable =
    CharactersTable(
        full_name = fullName,
        nickname = nickname,
        hogwarts_house = hogwartsHouse,
        interpreted_by = interpretedBy,
        children = children,
        image = image,
        birthDay = birthdate,
        num = index.toLong(),
    )
