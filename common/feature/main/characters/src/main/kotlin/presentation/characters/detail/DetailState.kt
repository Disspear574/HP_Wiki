package presentation.characters.detail

import domain.models.CharacterModel

internal data class DetailState(
    val character: CharacterModel = CharacterModel.empty,
)
