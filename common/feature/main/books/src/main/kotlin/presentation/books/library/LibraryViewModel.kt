package presentation.books.library

import androidx.lifecycle.viewModelScope
import domain.usecase.GetAllBooksUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import utils.BaseViewModel

private typealias State = LibraryState
private typealias SideEffect = LibrarySideEffect

internal class LibraryViewModel(
    private val getAllBooksUC: GetAllBooksUseCase,
) : BaseViewModel<State, SideEffect>(State()) {
    init {
        intent {
            getAllBooks()
        }
    }

    private fun getAllBooks() {
        intent {
            viewModelScope.launch(Dispatchers.IO) {
                val booksList = getAllBooksUC()
                reduce {
                    state.copy(booksList = booksList)
                }
            }
        }
    }

    fun onShowDetail(id: Int) {
        intent {
            postSideEffect(LibrarySideEffect.ShowDetails(id))
        }
    }
}
