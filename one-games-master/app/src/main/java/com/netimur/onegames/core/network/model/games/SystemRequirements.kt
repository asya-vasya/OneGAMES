package com.netimur.onegames.core.network.model.games

import com.google.gson.annotations.SerializedName

class SystemRequirements(
    @SerializedName("os") val os: String,
    @SerializedName("processor") val processor: String,
    @SerializedName("memory") val memory: String,
    @SerializedName("graphics") val graphics: String,
    @SerializedName("storage") val storage: String,
)
