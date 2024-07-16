package presentation.characters.library

import androidx.lifecycle.viewModelScope
import domain.usecase.GetAllCharactersUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import utils.BaseViewModel

private typealias State = LibraryState
private typealias SideEffect = LibrarySideEffect

class LibraryViewModel(
    private val getAllCharUC: GetAllCharactersUseCase,
) : BaseViewModel<State, SideEffect>(State()) {
    init {
        intent {
            getAllCharacters()
        }
    }

    private fun getAllCharacters() {
        intent {
            viewModelScope.launch(Dispatchers.IO) {
                val charactersList = getAllCharUC()
                reduce {
                    state.copy(charactersList = charactersList)
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
