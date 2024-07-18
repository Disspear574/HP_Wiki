package presentation.books.library

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import components.layout.ItemsList
import org.orbitmvi.orbit.compose.collectAsState

@Composable
internal fun LibraryScreen(vm: LibraryViewModel) {
    val state by vm.collectAsState()

    LazyVerticalGrid(
        modifier =
        Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        columns = GridCells.Fixed(count = 2),
        contentPadding =
        PaddingValues(
            bottom = WindowInsets.systemBars.asPaddingValues().calculateBottomPadding(),
        ),
    ) {
        items(items = state.booksList) { book ->
            ItemsList(
                image = book.cover,
                text = book.title,
                onClick = { vm.onShowDetail(book.number) },
            )
        }
    }
}
