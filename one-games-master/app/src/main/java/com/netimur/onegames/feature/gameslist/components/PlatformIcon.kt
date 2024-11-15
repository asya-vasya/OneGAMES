package com.netimur.onegames.feature.gameslist.components

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.netimur.onegames.R
import com.netimur.onegames.data.games.model.Platform

@Composable
fun PlatformIcon(platform: Platform, modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(
            when (platform) {
                Platform.WINDOWS -> R.drawable.windows_icon
                Platform.XBOX -> R.drawable.xbox_icon
                Platform.PLAY_STATION -> R.drawable.playstation_icon
                Platform.BROWSER -> R.drawable.globe_icon
                Platform.UNKNOWN -> R.drawable.question_mark_icon
            },
        ),
        contentDescription = null,
        modifier = modifier,
    )
}
