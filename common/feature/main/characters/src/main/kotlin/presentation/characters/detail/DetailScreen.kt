package presentation.characters.detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
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
    val character = state.character

    CenteredColumn(
        vertical = Arrangement.Top,
        modifier =
            Modifier
                .verticalScroll(
                    state = rememberScrollState(),
                ),
    ) {
        TextInsideImage(
            image = character.image,
            text = character.fullName,
        )
        Spacer(modifier = Modifier.height(20.dp))
        TextRow(
            title = "Прозвище:",
            textContent = character.nickName,
        )
        TextRow(
            title = "Филиал Хогвартса:",
            textContent = character.hogwartsHouse,
        )
        TextRow(
            title = "День рождения:",
            textContent = character.birthDay,
        )
        TextRow(
            title = "Сыгран:",
            textContent = character.interpretedBy,
        )
        TextRow(
            title = "Дети",
            content = {
                character.children.forEach {
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(text = it, style = MaterialTheme.typography.titleSmall, modifier = Modifier.padding(start = 16.dp))
                }
            },
            modifier = Modifier.navigationBarsPadding(),
        )
    }
}
