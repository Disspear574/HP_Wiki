package presentation.characters.root

import kotlinx.serialization.Serializable

@Serializable
sealed class CharacterScreens {
    @Serializable
    data object CharacterLibrary

    @Serializable
    data class CharacterDetail(
        val id: Int,
    )
}
