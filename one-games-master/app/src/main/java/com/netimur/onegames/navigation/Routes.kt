package com.netimur.onegames.navigation

import kotlinx.serialization.Serializable

@Serializable
object GamesList

@Serializable
data class GameDetails(
    val gameId: Int,
    val gameName: String,
)
