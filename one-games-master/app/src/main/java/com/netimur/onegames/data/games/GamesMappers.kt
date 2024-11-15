package com.netimur.onegames.data.games

import com.netimur.onegames.core.storage.model.GameEntity
import com.netimur.onegames.core.utils.mapList
import com.netimur.onegames.core.utils.toLocalDateOrNull
import com.netimur.onegames.data.games.model.Game
import com.netimur.onegames.data.games.model.Genre
import com.netimur.onegames.data.games.model.Platform
import com.netimur.onegames.core.network.model.games.Game as GameBackendModel

internal fun List<GameBackendModel>.toEntities() = mapList { toEntity() }

internal fun GameBackendModel.toEntity() = GameEntity(
    id = id,
    title = title,
    thumbnail = thumbnail,
    shortDescription = shortDescription,
    gameUrl = gameUrl,
    genre = genre,
    platforms = platform,
    publisher = publisher,
    developer = developer,
    releaseDate = releaseDate,
    freeToGameProfileUrl = freeToGameProfileUrl,
)

internal fun GameEntity.toDomain() = Game(
    id = id,
    title = title ?: "",
    shortDescription = shortDescription ?: "",
    platforms = platforms?.let(::parsePlatforms) ?: emptyList(),
    thumbnailUrl = thumbnail ?: "",
    releaseDate = releaseDate?.toLocalDateOrNull(),
    publisher = publisher ?: "",
    genre = genre?.let(::parseGenre) ?: Genre.UNKNOWN,
    gameUrl = gameUrl ?: "",
    developer = developer ?: "",
)

private fun parsePlatforms(platforms: String): List<Platform> {
    return Platform.entries.filter { platform ->
        platforms.contains(other = platform.name, ignoreCase = true)
    }
}

private fun parseGenre(genre: String): Genre {
    return Genre.entries.firstOrNull {
        genre.contains(other = it.displayName, ignoreCase = true)
    } ?: Genre.UNKNOWN
}
