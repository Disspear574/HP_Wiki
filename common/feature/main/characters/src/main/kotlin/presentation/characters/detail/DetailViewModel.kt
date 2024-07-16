package presentation.characters.detail

import androidx.lifecycle.viewModelScope
import domain.usecase.GetCharacterByIdUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import utils.BaseViewModel

private typealias State = DetailState
private typealias SideEffect = DetailSideEffect

internal class DetailViewModel(
    private val id: Int,
    private val getCharByIdUC: GetCharacterByIdUseCase,
) : BaseViewModel<State, SideEffect>(State()) {
    init {
        intent {
            getCharacter()
        }
    }

    private fun getCharacter() {
        intent {
            viewModelScope.launch(Dispatchers.IO) {
                val character = getCharByIdUC(id)
                reduce {
                    state.copy(
                        character = character,
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
