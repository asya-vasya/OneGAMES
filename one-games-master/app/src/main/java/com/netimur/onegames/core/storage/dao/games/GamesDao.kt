package com.netimur.onegames.core.storage.dao.games

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.netimur.onegames.core.storage.model.GameDetailsEntity
import com.netimur.onegames.core.storage.model.GameEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface GamesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun storeGames(games: List<GameEntity>)

    @Query("SELECT * FROM games")
    fun observeGames(): Flow<List<GameEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun storeGameDetails(gameDetails: GameDetailsEntity)

    @Query("SELECT * FROM gameDetails")
    fun observeGameDetails(): Flow<List<GameDetailsEntity>>
}
