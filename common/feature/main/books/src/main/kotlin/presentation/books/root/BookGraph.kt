package presentation.books.root

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import androidx.navigation.toRoute
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf
import org.orbitmvi.orbit.compose.collectSideEffect
import presentation.books.detail.DetailScreen
import presentation.books.detail.DetailSideEffect
import presentation.books.detail.DetailViewModel
import presentation.books.library.LibraryScreen
import presentation.books.library.LibrarySideEffect
import presentation.books.library.LibraryViewModel
import utils.BarsVisibility
import utils.Tabs

fun NavGraphBuilder.booksGraph(
    navController: NavController,
    barsVisibility: BarsVisibility,
) {
    navigation<Tabs.Books>(startDestination = BooksScreen.BooksLibrary) {
        addBooksLibrary(navController = navController, barsVisibility = barsVisibility)
        addBookDetail(navController = navController, barsVisibility = barsVisibility)
    }
}

private fun NavGraphBuilder.addBooksLibrary(
    navController: NavController,
    barsVisibility: BarsVisibility,
) {
    composable<BooksScreen.BooksLibrary> {
        barsVisibility.topBars.hide()

        val vm: LibraryViewModel = koinViewModel()
        vm.collectSideEffect {
            when (it) {
                is LibrarySideEffect.ShowDetails -> {
                    navController.navigate(route = BooksScreen.BookDetail(it.id))
                }
            }
        }
        LibraryScreen(vm)
    }
}

private fun NavGraphBuilder.addBookDetail(
    navController: NavController,
    barsVisibility: BarsVisibility,
) {
    composable<BooksScreen.BookDetail> {
        barsVisibility.topBars.show()

        val bookId = it.toRoute<BooksScreen.BookDetail>().bookId

        val vm: DetailViewModel = koinViewModel(parameters = { parametersOf(bookId) })
        vm.collectSideEffect { sideEffect ->
            when (sideEffect) {
                is DetailSideEffect.Back ->
                    navController.popBackStack()
            }
        }
        DetailScreen(vm)
    }
}
