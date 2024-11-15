package com.netimur.onegames.feature.gamedetails

import  androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.netimur.onegames.core.designsystem.Spaces
import com.netimur.onegames.feature.gamedetails.components.DetailsContent
import com.netimur.onegames.ui.theme.text_color

@Composable
fun GameDetailsScreen(
    onBack: () -> Unit,
    gameId: Int,
    gameName: String,
    viewModel: GameDetailsViewModel,
) {
    LaunchedEffect(key1 = Unit) {
        viewModel.requestGameDetailsByGameId(gameId = gameId)
    }

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .systemBarsPadding(),
        topBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(all = Spaces.xs),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(space = Spaces.xs),
            ) {
                Icon(
                    modifier = Modifier.clickable(onClick = onBack),
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = null,
                    tint = Color.White
                )
                Text(
                    text = gameName,
                    style = MaterialTheme.typography.headlineMedium,
                    color = text_color
                )
            }
        }
    ) { scaffoldPaddingValues ->
        scaffoldPaddingValues
        when (uiState.gameDetails) {
            is GameDetailsWrapper.Specified -> {
                DetailsContent(
                    gameDetails = (uiState.gameDetails as GameDetailsWrapper.Specified).gameDetails,
                    isTextCollapsed = uiState.isTextCollapsed,
                    collapsDescription = viewModel::collapseDescription,
                    expandDescription = viewModel::expandDescription
                )
            }
            GameDetailsWrapper.Unspecified -> {
                ErrorContent()
            }
        }
    }
}

@Composable
private fun ErrorContent(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.errorContainer),
    )
}