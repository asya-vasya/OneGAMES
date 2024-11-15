package com.netimur.onegames.core.network.di

import com.netimur.onegames.core.network.services.GamesService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@InstallIn(SingletonComponent::class)
@Module
object GamesServiceModule {
    @Provides
    fun provideGamesService(@RetrofitModule.GamesRetrofit retrofit: Retrofit): GamesService {
        return retrofit.create(GamesService::class.java)
    }
}
