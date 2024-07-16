package domain.repository

import domain.models.CharacterModel

interface CharacterRepository {
    suspend fun getAllCharacters(): List<CharacterModel>

    suspend fun getCharacterById(id: Int): CharacterModel

    suspend fun fetch(): Boolean

    fun clear()
}
