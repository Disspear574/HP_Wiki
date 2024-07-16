package utils

import androidx.lifecycle.ViewModel
import org.koin.core.component.KoinComponent
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.viewmodel.container

abstract class BaseViewModel<State : Any, SideEffect : Any>(
    state: State,
) : ViewModel(),
    ContainerHost<State, SideEffect>,
    KoinComponent {
    override val container: Container<State, SideEffect> = container(state)
}
