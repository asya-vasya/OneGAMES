package com.netimur.onegames.core.network.model.games

import com.google.gson.annotations.SerializedName

class GameDetails(
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String,
    @SerializedName("thumbnail") val thumbnailUrl: String,
    @SerializedName("status") val status: String,
    @SerializedName("short_description") val shortDescription: String,
    @SerializedName("description") val description: String,
    @SerializedName("game_url") val gameUrl: String,
    @SerializedName("genre") val genre: String,
    @SerializedName("platform") val platform: String,
    @SerializedName("publisher") val publisher: String,
    @SerializedName("developer") val developer: String,
    @SerializedName("release_date") val releaseDate: String,
    @SerializedName("freetogame_profile_url") val freeToGameProfileUrl: String,
    @SerializedName("minimum_system_requirements") val minimumSystemRequirements: SystemRequirements,
    @SerializedName("screenshots") val screenshots: List<GameScreenshot>,
)
