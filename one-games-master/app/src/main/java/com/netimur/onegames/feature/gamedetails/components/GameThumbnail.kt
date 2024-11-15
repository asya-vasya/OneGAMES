package com.netimur.onegames.feature.gamedetails.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.netimur.onegames.data.games.model.GameDetails

@Composable
fun GameThumbnail(gameDetails: GameDetails,){
    Row {
        AsyncImage(
            model = gameDetails.thumbnailUrl,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .height(300.dp)
                .size(450.dp)
                .padding(top = 60.dp)
        )}
}
