package com.netimur.onegames.feature.gameslist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.netimur.onegames.data.games.repository.GamesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GamesListViewModel @Inject constructor(
    private val gamesRepository: GamesRepository,
) : ViewModel() {
    private val _uiState = MutableStateFlow(GamesListUIState.empty)
    val uiState: StateFlow<GamesListUIState> = _uiState

    init {
        observeGames()
        requestGames()
    }

    fun requestGames() {
        viewModelScope.launch {
            _uiState.update {
                it.copy(
                    isLoading = true,
                )
            }
            gamesRepository.requestGames()
            _uiState.update {
                it.copy(
                    isLoading = false,
                )
            }
        }
    }

    private fun observeGames() {
        viewModelScope.launch {
            gamesRepository.observeGames().collect { games ->
                _uiState.update {
                    it.copy(
                        games = games,
                    )
                }
            }
        }
    }
}
