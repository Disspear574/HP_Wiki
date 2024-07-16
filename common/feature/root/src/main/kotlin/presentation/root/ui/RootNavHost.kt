package presentation.root.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import org.koin.androidx.compose.koinViewModel
import org.orbitmvi.orbit.compose.collectSideEffect
import presentation.books.root.booksGraph
import presentation.characters.root.charactersGraph
import presentation.root.Screen
import presentation.splash.SplashScreen
import presentation.splash.SplashSideEffect
import presentation.splash.SplashViewModel
import soup.compose.material.motion.animation.materialSharedAxisYIn
import soup.compose.material.motion.animation.materialSharedAxisYOut
import soup.compose.material.motion.animation.rememberSlideDistance
import utils.BarsVisibility
import utils.Tabs

@Composable
internal fun RootNavHost(
    navController: NavHostController,
    barsVisibility: BarsVisibility,
    modifier: Modifier = Modifier,
) {
    val slideDistance = rememberSlideDistance(100.dp)
    NavHost(
        navController = navController,
        startDestination = Screen.Splash,
        modifier = modifier,
        enterTransition = {
            materialSharedAxisYIn(forward = true, slideDistance = slideDistance)
        },
        exitTransition = {
            materialSharedAxisYOut(forward = false, slideDistance = slideDistance)
        },
    ) {
        addSplash(navController = navController, barsVisibility = barsVisibility)
        mainGraph(navController = navController, barsVisibility = barsVisibility)
    }
}

private fun NavGraphBuilder.addSplash(
    navController: NavController,
    barsVisibility: BarsVisibility,
) {
    composable<Screen.Splash> {
        barsVisibility.showTabs.hide()
        val vm: SplashViewModel = koinViewModel()
        vm.collectSideEffect {
            when (it) {
                SplashSideEffect.Complete -> {
                    navController.navigate(route = Screen.Main) {
                        popUpTo(Screen.Splash) {
                            inclusive = true
                        }
                    }
                }
            }
        }
        SplashScreen(vm = vm)
    }
}

private fun NavGraphBuilder.mainGraph(
    navController: NavController,
    barsVisibility: BarsVisibility,
) {
    navigation<Screen.Main>(startDestination = Tabs.Books) {
        barsVisibility.showTabs.show()
        booksGraph(navController = navController, barsVisibility = barsVisibility)
        charactersGraph(navController = navController, barsVisibility = barsVisibility)
    }
}
