package domain.usecase

import domain.repository.BookRepository

class GetBookByIdUseCase(
    private val repository: BookRepository,
) {
    suspend operator fun invoke(id: Int) = repository.getBookById(id)
}
