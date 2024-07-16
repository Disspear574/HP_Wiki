package network.impl

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import network.api.CharactersApi
import network.model.Character

class CharactersApiImpl(
    private val httpClient: HttpClient,
) : CharactersApi {
    override suspend fun getCharacters(): List<Character> = httpClient.get("https://potterapi-fedeperin.vercel.app/en/characters").body()

    override suspend fun getCharacterDetailById(id: Int): Character {
        val list: List<Character> =
            httpClient.get("https://potterapi-fedeperin.vercel.app/en/characters").body()
        return list[id]
    }
}
