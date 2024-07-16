package data.entity

import androidx.compose.runtime.Immutable
import domain.models.CharacterModel
import kotlinx.serialization.Serializable

@Serializable
@Immutable
data class CharacterEntity(
    val fullName: String,
    val nickName: String,
    val hogwartsHouse: String,
    val interpretedBy: String,
    val children: List<String>,
    val image: String,
    val birthDay: String,
    val index: Int,
) {
    fun toDomain(): CharacterModel =
        CharacterModel(
            fullName = fullName,
            nickName = nickName,
            hogwartsHouse = hogwartsHouse,
            interpretedBy = interpretedBy,
            children = children,
            image = image,
            birthDay = birthDay,
            index = index,
        )
}
