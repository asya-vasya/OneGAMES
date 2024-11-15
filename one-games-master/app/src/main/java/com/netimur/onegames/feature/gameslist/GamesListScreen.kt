package com.netimur.onegames.feature.gameslist

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.netimur.onegames.core.designsystem.Spaces
import com.netimur.onegames.feature.gameslist.components.GamePreview
import com.netimur.onegames.feature.gameslist.components.GamesListHeader
import com.netimur.onegames.feature.gameslist.components.RequestGamesButton

@Composable
fun GamesListScreen(
    navigateToDetailsScreen: (gameId: Int, gameName: String) -> Unit,
    viewModel: GamesListViewModel,
) {
    val uiState by viewModel.uiState.collectAsState()
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .systemBarsPadding()
            .background(
                color = if (uiState.isError) {
                    MaterialTheme.colorScheme.errorContainer
                } else {
                    MaterialTheme.colorScheme.primary
                },
            ),
        topBar = {
            GamesListHeader(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(all = Spaces.xs),
            )
        },
        bottomBar = {
            RequestGamesButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                onClick = viewModel::requestGames,
            )
        },
        content = { scaffoldPaddingValues ->
            AnimatedContent(
                modifier = Modifier.padding(paddingValues = scaffoldPaddingValues),
                targetState = uiState.isLoading,
            ) { state ->
                if (state) {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        CircularProgressIndicator()
                    }
                } else {
                    LazyColumn(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.spacedBy(space = 8.dp),
                    ) {
                        items(items = uiState.games, key = { it.id }) { game ->
                            GamePreview(
                                modifier = Modifier.fillMaxWidth(),
                                game = game,
                                onClick = {
                                    navigateToDetailsScreen(
                                        game.id,
                                        game.title,
                                    )
                                },
                            )
                        }
                    }
                }
            }
        },
    )
}
