package com.netimur.onegames.core.storage.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "games")
data class GameEntity(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "title") val title: String?,
    @ColumnInfo(name = "thumbnail") val thumbnail: String?,
    @ColumnInfo(name = "short_description") val shortDescription: String?,
    @ColumnInfo(name = "game_url") val gameUrl: String?,
    @ColumnInfo(name = "genre") val genre: String?,
    @ColumnInfo(name = "platform") val platforms: String?,
    @ColumnInfo(name = "publisher") val publisher: String?,
    @ColumnInfo(name = "developer") val developer: String?,
    @ColumnInfo(name = "release_date") val releaseDate: String?,
    @ColumnInfo(name = "freetogame_profile_url") val freeToGameProfileUrl: String?,
)

@Entity(tableName = "gameDetails")
data class GameDetailsEntity(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "thumbnail") val thumbnail: String?,
    @ColumnInfo(name = "title") val title: String?,
    @ColumnInfo(name = "short_description") val shortDescription: String?,
    @ColumnInfo(name = "description") val description: String?,
    @ColumnInfo(name = "game_url") val gameUrl: String?,
    @ColumnInfo(name = "genre") val genre: String?,
    @ColumnInfo(name = "developer") val developer: String?,
    @ColumnInfo(name = "release_date") val releaseDate: String?,
)

