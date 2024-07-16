package presentation.books.detail

import androidx.lifecycle.viewModelScope
import domain.usecase.GetBookByIdUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import utils.BaseViewModel

private typealias State = DetailState
private typealias SideEffect = DetailSideEffect

internal class DetailViewModel(
    private val id: Int,
    private val bookByIdUC: GetBookByIdUseCase,
) : BaseViewModel<State, SideEffect>(State()) {
    init {
        intent {
            getBook()
        }
    }

    private fun getBook() {
        intent {
            viewModelScope.launch(Dispatchers.IO) {
                val book = bookByIdUC(id)
                reduce {
                    state.copy(
                        book = book,
                    )
                }
            }
        }
    }

    fun onBackClicked() {
        intent {
            postSideEffect(DetailSideEffect.Back)
        }
    }
}
