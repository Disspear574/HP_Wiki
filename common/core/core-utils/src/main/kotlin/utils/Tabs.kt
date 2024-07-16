package utils

import kotlinx.serialization.Serializable

@Serializable
sealed class Tabs {
    @Serializable
    data object Books : Tabs()

    @Serializable
    data object Characters : Tabs()

    companion object {
        val entries: List<Tabs> = listOf(Books, Characters)
    }
}
