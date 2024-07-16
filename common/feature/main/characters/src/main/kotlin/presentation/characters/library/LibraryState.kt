package presentation.characters.library

import androidx.compose.runtime.Stable
import domain.models.CharacterModel

@Stable
data class LibraryState(
    val charactersList: List<CharacterModel> = emptyList(),
)
