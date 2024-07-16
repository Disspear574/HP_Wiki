package domain.usecase

import domain.repository.BookRepository

class GetAllBooksUseCase(
    private val repository: BookRepository,
) {
    suspend operator fun invoke() = repository.getAllBooks()
}
