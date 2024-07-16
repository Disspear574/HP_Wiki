package domain.usecase

import domain.repository.CharacterRepository

class GetCharacterByIdUseCase(
    private val repository: CharacterRepository,
) {
    suspend operator fun invoke(id: Int) = repository.getCharacterById(id)
}
