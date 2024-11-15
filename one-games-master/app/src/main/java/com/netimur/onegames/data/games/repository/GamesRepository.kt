package com.netimur.onegames.data.games.repository

import com.netimur.onegames.data.games.model.Game
import com.netimur.onegames.data.games.model.GameDetails
import kotlinx.coroutines.flow.Flow

interface GamesRepository {
    suspend fun requestGames()
    fun observeGames(): Flow<List<Game>>

    suspend fun requestGameDetailsById(gameId: Int)
    fun observeGameDetails(): Flow<List<GameDetails>>

}
