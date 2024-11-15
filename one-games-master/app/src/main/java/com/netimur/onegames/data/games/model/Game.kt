package com.netimur.onegames.data.games.model

import java.time.LocalDate

data class Game(
    val id: Int,
    val title: String,
    val shortDescription: String,
    val gameUrl: String,
    val platforms: List<Platform>,
    val thumbnailUrl: String,
    val genre: Genre,
    val publisher: String,
    val developer: String,
    val releaseDate: LocalDate?,
)
