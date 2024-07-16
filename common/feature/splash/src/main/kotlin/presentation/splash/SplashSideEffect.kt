package presentation.splash

sealed class SplashSideEffect {
    data object Complete : SplashSideEffect()
}
