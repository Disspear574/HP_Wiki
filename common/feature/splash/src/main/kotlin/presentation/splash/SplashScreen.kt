package presentation.splash

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import components.layout.CenteredColumn
import org.orbitmvi.orbit.compose.collectAsState
import presentation.splash.ui.ErrorScreen
import presentation.splash.ui.LoadingScreen
import presentation.splash.ui.SuccessDelayScreen
import utils.UiState

@Composable
fun SplashScreen(vm: SplashViewModel) {
    val state by vm.collectAsState()

    CenteredColumn {
        when (state.result) {
            is UiState.Failed -> ErrorScreen(onClick = vm::refresh)

            UiState.Loading -> LoadingScreen()

            UiState.Success -> SuccessDelayScreen()

            null -> Unit
        }
    }
}
