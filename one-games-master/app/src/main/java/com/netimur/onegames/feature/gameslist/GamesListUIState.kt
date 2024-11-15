package com.netimur.onegames.feature.gameslist

import androidx.compose.runtime.Immutable
import com.netimur.onegames.data.games.model.Game

@Immutable
data class GamesListUIState(
    val isLoading: Boolean,
    val games: List<Game>,
    val isError: Boolean,
) {
    companion object {
        val empty = GamesListUIState(
            isLoading = false,
            games = emptyList(),
            isError = false,
        )
    }
}
