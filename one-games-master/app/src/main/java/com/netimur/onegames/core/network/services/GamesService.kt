package com.netimur.onegames.core.network.services

import com.netimur.onegames.core.network.model.games.Game
import com.netimur.onegames.core.network.model.games.GameDetails
import retrofit2.http.GET
import retrofit2.http.Query

interface GamesService {
    @GET(value = "games")
    suspend fun requestGames(): List<Game>

    @GET("game")
    suspend fun requestDetailsByGameId(@Query("id") gameId: Int): GameDetails
}
