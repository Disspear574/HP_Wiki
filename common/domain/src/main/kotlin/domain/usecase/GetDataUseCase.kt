package domain.usecase

import domain.repository.BookRepository
import domain.repository.CharacterRepository
import domain.repository.ConfigRepository

class GetDataUseCase(
    private val bookRepository: BookRepository,
    private val characterRepository: CharacterRepository,
    private val configRepository: ConfigRepository,
) {
    suspend operator fun invoke(): Boolean =
        if (!configRepository.createdDatabase) {
            bookRepository.clear()
            characterRepository.clear()
            bookRepository.fetch().apply { configRepository.createdDatabase = this }
            characterRepository.fetch().apply { configRepository.createdDatabase = this }
        } else {
            true
        }
}
