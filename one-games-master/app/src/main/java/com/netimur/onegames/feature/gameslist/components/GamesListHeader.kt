package com.netimur.onegames.feature.gameslist.components

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.netimur.onegames.R

@Composable
fun GamesListHeader(modifier: Modifier = Modifier) {
    Box(modifier = modifier, contentAlignment = Alignment.CenterStart) {
        Text(
            modifier = modifier,
            text = stringResource(R.string.free_to_play_games),
            style = MaterialTheme.typography.headlineMedium,
        )
    }
}
