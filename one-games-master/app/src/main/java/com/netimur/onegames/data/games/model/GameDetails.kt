package com.netimur.onegames.data.games.model


data class GameDetails(
    val id: Int,
    val gameUrl: String,
    val title: String,
    val thumbnailUrl: String,
    val status: Genre,
    val shortDescription: String,
    val description: String,
    val developer: String,
    val releaseDate: String
)
