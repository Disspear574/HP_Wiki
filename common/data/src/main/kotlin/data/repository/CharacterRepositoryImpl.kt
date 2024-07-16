package data.repository

import data.datastore.CharacterDataSource
import domain.repository.CharacterRepository

class CharacterRepositoryImpl(
    private val storage: CharacterDataSource,
) : CharacterRepository {
    override suspend fun getAllCharacters() = storage.getAll().map { it.toDomain() }

    override suspend fun getCharacterById(id: Int) = storage.getById(id).toDomain()

    override suspend fun fetch() = storage.fetch()

    override fun clear() = storage.clear()
}
