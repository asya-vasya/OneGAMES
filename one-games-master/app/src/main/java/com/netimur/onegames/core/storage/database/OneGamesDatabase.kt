package com.netimur.onegames.core.storage.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.netimur.onegames.core.storage.dao.games.GamesDao
import com.netimur.onegames.core.storage.model.GameDetailsEntity
import com.netimur.onegames.core.storage.model.GameEntity

@Database(entities = [GameEntity::class, GameDetailsEntity::class], version = 2)
abstract class OneGamesDatabase : RoomDatabase() {
    abstract fun gamesDao(): GamesDao
}