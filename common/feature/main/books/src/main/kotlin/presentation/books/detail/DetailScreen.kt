package presentation.books.detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import components.layout.CenteredColumn
import components.text.TextInsideImage
import components.text.TextRow
import org.orbitmvi.orbit.compose.collectAsState

@Composable
internal fun DetailScreen(vm: DetailViewModel) {
    val state by vm.collectAsState()
    val book = state.book
    CenteredColumn(
        vertical = Arrangement.Top,
        modifier =
            Modifier
                .verticalScroll(
                    state = rememberScrollState(),
                ),
    ) {
        TextInsideImage(
            image = book.cover,
            text = book.title,
        )
        Spacer(modifier = Modifier.height(20.dp))

        TextRow(
            title = "Название на анг",
            textContent = book.originalTitle,
        )
        TextRow(
            title = "Дата написания",
            textContent = book.releaseDate,
        )
        TextRow(
            title = "Количество страниц",
            textContent = book.pages.toString(),
        )
        TextRow(
            title = "Номер книги",
            textContent = book.number.toString(),
        )
        TextRow(
            title = "Описание",
            textContent = book.description,
            modifier = Modifier.navigationBarsPadding(),
        )
    }
}
