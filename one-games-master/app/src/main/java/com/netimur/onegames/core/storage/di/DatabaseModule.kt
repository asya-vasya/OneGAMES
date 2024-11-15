package com.netimur.onegames.core.storage.di

import android.content.Context
import androidx.room.Room
import com.netimur.onegames.core.storage.database.OneGamesDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {

    @Singleton
    @Provides
    fun provideGamesDatabase(@ApplicationContext context: Context): OneGamesDatabase {
        return Room.databaseBuilder(
            context = context,
            klass = OneGamesDatabase::class.java,
            name = "one_games_database",
        )
            .fallbackToDestructiveMigration()
            .build()
    }
}