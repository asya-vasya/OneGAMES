package com.netimur.onegames.data.games

import com.netimur.onegames.core.storage.model.GameDetailsEntity
import com.netimur.onegames.core.utils.mapList
import com.netimur.onegames.core.utils.toLocalDateOrNull
import com.netimur.onegames.data.games.model.GameDetails
import com.netimur.onegames.data.games.model.Genre
import com.netimur.onegames.core.network.model.games.GameDetails as GameDetailsBackendModel

internal fun List<GameDetailsBackendModel>.toEntities() = mapList { toEntity() }

internal fun GameDetailsBackendModel.toEntity() = GameDetailsEntity(
    id = id,
    title = title,
    thumbnail = thumbnailUrl,
    shortDescription = shortDescription,
    gameUrl = gameUrl,
    genre = genre,
    developer = developer,
    releaseDate = releaseDate,
    description = description
)
internal fun GameDetailsEntity.toDomain() = GameDetails(
    id = id,
    title = title ?: "",
    shortDescription = shortDescription ?: "",
    description = description ?: "",
    thumbnailUrl = thumbnail ?: "",
    releaseDate = releaseDate?.toLocalDateOrNull().toString(),
    status = genre?.let(::parseGenre) ?: Genre.UNKNOWN,
    gameUrl = gameUrl ?: "",
    developer = developer ?: "",
)
private fun parseGenre(genre: String): Genre {
    return Genre.entries.firstOrNull {
        genre.contains(other = it.displayName, ignoreCase = true)
    } ?: Genre.UNKNOWN
}