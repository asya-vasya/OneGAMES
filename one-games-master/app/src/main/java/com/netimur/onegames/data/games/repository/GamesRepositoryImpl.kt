package com.netimur.onegames.data.games.repository

import com.netimur.onegames.core.coroutines.OneGamesRestCoroutineContext
import com.netimur.onegames.core.network.services.GamesService
import com.netimur.onegames.core.storage.dao.games.GamesDao
import com.netimur.onegames.data.games.model.Game
import com.netimur.onegames.data.games.model.GameDetails
import com.netimur.onegames.data.games.toDomain
import com.netimur.onegames.data.games.toEntities
import com.netimur.onegames.data.games.toEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

class GamesRepositoryImpl(
    private val gamesService: GamesService,
    private val gamesDao: GamesDao,
) : GamesRepository {
    override suspend fun requestGames() {
        withContext(OneGamesRestCoroutineContext.context) {
            val games = gamesService.requestGames()
            gamesDao.storeGames(games = games.toEntities())
        }
    }

    override fun observeGames(): Flow<List<Game>> {
        return gamesDao.observeGames().map { games ->
            games.map { it.toDomain() }
        }
    }

    override suspend fun requestGameDetailsById(gameId: Int) {
        withContext(Dispatchers.IO) {
            val gameDetails = gamesService.requestDetailsByGameId(gameId)
            gamesDao.storeGameDetails(gameDetails =gameDetails.toEntity())
        }
    }

    override fun observeGameDetails(): Flow<List<GameDetails>> {
        return gamesDao.observeGameDetails().map { details ->
            details.map { it.toDomain() }
        }
    }
}
