package presentation.characters.root

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import androidx.navigation.toRoute
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf
import org.orbitmvi.orbit.compose.collectSideEffect
import presentation.characters.detail.DetailScreen
import presentation.characters.detail.DetailViewModel
import presentation.characters.library.LibraryScreen
import presentation.characters.library.LibrarySideEffect
import presentation.characters.library.LibraryViewModel
import utils.BarsVisibility
import utils.Tabs

fun NavGraphBuilder.charactersGraph(
    navController: NavController,
    barsVisibility: BarsVisibility,
) {
    navigation<Tabs.Characters>(startDestination = CharacterScreens.CharacterLibrary) {
        addLibrary(navController = navController, barsVisibility = barsVisibility)
        addDetail(navController = navController, barsVisibility = barsVisibility)
    }
}

private fun NavGraphBuilder.addLibrary(
    navController: NavController,
    barsVisibility: BarsVisibility,
) {
    composable<CharacterScreens.CharacterLibrary> {
        barsVisibility.topBars.hide()

        val vm: LibraryViewModel = koinViewModel()
        vm.collectSideEffect { sideEffect ->
            when (sideEffect) {
                is LibrarySideEffect.ShowDetails ->
                    navController.navigate(CharacterScreens.CharacterDetail(sideEffect.id))
            }
        }
        LibraryScreen(vm)
    }
}

private fun NavGraphBuilder.addDetail(
    navController: NavController,
    barsVisibility: BarsVisibility,
) {
    composable<CharacterScreens.CharacterDetail> {
        barsVisibility.topBars.show()
        val charId = it.toRoute<CharacterScreens.CharacterDetail>().id
        val vm: DetailViewModel = koinViewModel(parameters = { parametersOf(charId) })
        DetailScreen(vm)
    }
}
