package com.netimur.onegames.feature.gamedetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.netimur.onegames.data.games.repository.GamesRepository
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GameDetailsViewModel @Inject constructor(
    private val gamesRepository: GamesRepository,
) : ViewModel() {
    private val _uiState = MutableStateFlow(GameDetailsUIState.empty)
    val uiState = _uiState.asStateFlow()

    var currentId = 0

    init {
        observeGamesDetails()
    }

    fun requestGameDetailsByGameId(gameId: Int) {
        currentId = gameId
        viewModelScope.launch{
            gamesRepository.requestGameDetailsById(gameId=gameId)
        }
    }

    private fun observeGamesDetails() {
        viewModelScope.launch {
            gamesRepository.observeGameDetails().collect { details ->
                details.find {
                    it.id == currentId
                }?.let { details->
                    _uiState.update {
                        it.copy(
                            gameDetails = GameDetailsWrapper.Specified(details)
                        )
                    }
                }
            }
        }
    }

    fun collapseDescription(){
        _uiState.update {
            it.copy(isTextCollapsed = true)
        }
    }
    fun expandDescription(){
        _uiState.update {
            it.copy(isTextCollapsed = false)
        }
    }

}