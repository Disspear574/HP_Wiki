package network.api

import network.model.Character

interface CharactersApi {
    suspend fun getCharacters(): List<Character>

    suspend fun getCharacterDetailById(id: Int): Character
}
