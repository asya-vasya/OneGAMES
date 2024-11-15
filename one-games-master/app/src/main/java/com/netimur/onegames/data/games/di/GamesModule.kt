package com.netimur.onegames.data.games.di

import com.netimur.onegames.core.network.services.GamesService
import com.netimur.onegames.core.storage.dao.games.GamesDao
import com.netimur.onegames.data.games.repository.GamesRepository
import com.netimur.onegames.data.games.repository.GamesRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object GamesModule {

    @Provides
    fun provideGamesRepository(gamesService: GamesService, gamesDao: GamesDao): GamesRepository {
        return GamesRepositoryImpl(gamesService = gamesService, gamesDao = gamesDao)
    }
}
