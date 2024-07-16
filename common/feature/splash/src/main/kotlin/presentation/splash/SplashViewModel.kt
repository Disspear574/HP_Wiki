package presentation.splash

import domain.usecase.GetDataUseCase
import kotlinx.coroutines.delay
import utils.BaseViewModel
import utils.UiState

private typealias State = SplashState
private typealias SideEffect = SplashSideEffect

class SplashViewModel(
    private val isDataLoaded: GetDataUseCase,
) : BaseViewModel<State, SideEffect>(State()) {
    init {
        getData()
    }

    private fun getData() {
        intent {
            reduce { state.copy(result = UiState.Loading) }
            if (isDataLoaded()) {
                reduce { state.copy(result = UiState.Success) }
                delay(500)
                postSideEffect(SplashSideEffect.Complete)
            } else {
                reduce { state.copy(result = UiState.Failed()) }
            }
        }
    }

    fun refresh() {
        intent {
            reduce { state.copy(result = UiState.Loading) }
        }
    }
}
