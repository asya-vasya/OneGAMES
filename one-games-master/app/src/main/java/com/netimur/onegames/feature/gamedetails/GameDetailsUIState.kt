package com.netimur.onegames.feature.gamedetails

import androidx.compose.runtime.Immutable
import com.netimur.onegames.data.games.model.GameDetails

@Immutable
data class GameDetailsUIState(
    val gameDetails: GameDetailsWrapper,
    val isTextCollapsed: Boolean
) {
    companion object {
        val empty = GameDetailsUIState(
            gameDetails = GameDetailsWrapper.Unspecified,
            isTextCollapsed = true
        )
    }
}

sealed interface GameDetailsWrapper {
    data class Specified(val gameDetails: GameDetails) : GameDetailsWrapper
    data object Unspecified : GameDetailsWrapper
}
