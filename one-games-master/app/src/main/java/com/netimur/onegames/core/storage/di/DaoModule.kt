package com.netimur.onegames.core.storage.di

import com.netimur.onegames.core.storage.dao.games.GamesDao
import com.netimur.onegames.core.storage.database.OneGamesDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DaoModule {

    @Singleton
    @Provides
    fun provideGamesDao(oneGamesDatabase: OneGamesDatabase): GamesDao {
        return oneGamesDatabase.gamesDao()
    }
}
