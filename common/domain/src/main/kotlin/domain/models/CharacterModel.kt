package domain.models

import androidx.compose.runtime.Immutable

@Immutable
data class CharacterModel(
    val fullName: String,
    val nickName: String,
    val hogwartsHouse: String,
    val interpretedBy: String,
    val children: List<String>,
    val image: String,
    val birthDay: String,
    val index: Int,
) {
    companion object {
        val empty =
            CharacterModel(
                fullName = "",
                nickName = "",
                hogwartsHouse = "",
                interpretedBy = "",
                children = emptyList(),
                image = "",
                birthDay = "",
                index = 0,
            )
    }
}
