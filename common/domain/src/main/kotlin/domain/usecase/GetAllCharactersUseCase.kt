package domain.usecase

import domain.repository.CharacterRepository

class GetAllCharactersUseCase(
    private val repository: CharacterRepository,
) {
    suspend operator fun invoke() = repository.getAllCharacters()
}
