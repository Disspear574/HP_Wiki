package data.datastore

import data.entity.CharacterEntity

interface CharacterDataSource {
    suspend fun getAll(): List<CharacterEntity>

    suspend fun getById(id: Int): CharacterEntity

    suspend fun fetch(): Boolean

    fun clear()
}
