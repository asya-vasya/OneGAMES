package com.netimur.onegames.core.network.model.games

import com.google.gson.annotations.SerializedName

class GameScreenshot(
    @SerializedName("id") val id: Int,
    @SerializedName("image") val imageUrl: String,
)
