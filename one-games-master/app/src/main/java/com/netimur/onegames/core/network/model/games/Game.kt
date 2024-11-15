package com.netimur.onegames.core.network.model.games

import com.google.gson.annotations.SerializedName

data class Game(
    @SerializedName(value = "id") val id: Int,
    @SerializedName(value = "title") val title: String,
    @SerializedName(value = "thumbnail") val thumbnail: String,
    @SerializedName(value = "short_description") val shortDescription: String,
    @SerializedName(value = "game_url") val gameUrl: String,
    @SerializedName(value = "genre") val genre: String,
    @SerializedName(value = "platform") val platform: String,
    @SerializedName(value = "publisher") val publisher: String,
    @SerializedName(value = "developer") val developer: String,
    @SerializedName(value = "release_date") val releaseDate: String,
    @SerializedName(value = "freetogame_profile_url") val freeToGameProfileUrl: String,
)
