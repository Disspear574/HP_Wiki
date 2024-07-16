package presentation.root

import kotlinx.serialization.Serializable

@Serializable
internal sealed class Screen {
    @Serializable
    data object Splash

    @Serializable
    data object Main
}
