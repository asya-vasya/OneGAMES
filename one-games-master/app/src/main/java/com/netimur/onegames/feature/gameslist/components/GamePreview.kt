package com.netimur.onegames.feature.gameslist.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.netimur.onegames.data.games.model.Game
import com.netimur.onegames.data.games.model.Genre
import com.netimur.onegames.data.games.model.Platform
import java.time.LocalDate

@Composable
fun GamePreview(
    game: Game,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(color = MaterialTheme.colorScheme.primary)
            .clickable(onClick = onClick),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            model = game.thumbnailUrl,
            contentDescription = null,
            modifier = Modifier
                .size(70.dp)
                .padding(start = 8.dp, end = 8.dp),
            contentScale = ContentScale.Crop,
        )

        Column(
            modifier = Modifier
                .weight(1f)
                .padding(all = 8.dp),
            verticalArrangement = Arrangement.spacedBy(space = 4.dp),
        ) {
            GameName(name = game.title)
            GameDescription(description = game.shortDescription)
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(space = 8.dp),
            ) {
                items(items = game.platforms, key = { it.name }) {
                    PlatformIcon(platform = it, modifier = Modifier.size(24.dp))
                }
            }
        }
    }
}

@Composable
private fun GameName(modifier: Modifier = Modifier, name: String) {
    Text(
        modifier = modifier,
        text = name,
        style = MaterialTheme.typography.bodyMedium.copy(color = MaterialTheme.colorScheme.onPrimary),
    )
}

@Composable
private fun GameDescription(modifier: Modifier = Modifier, description: String) {
    Text(
        modifier = modifier,
        text = description,
        style = MaterialTheme.typography.bodySmall.copy(color = MaterialTheme.colorScheme.onPrimary),
        overflow = TextOverflow.Ellipsis,
        maxLines = 3,
    )
}

@Preview(locale = "kk")
@Preview(locale = "ru")
@Preview(locale = "en")
@PreviewLightDark
@Composable
private fun GamePreviewPreview() {
    GamePreview(
        game = Game(
            id = 1,
            title = "Witcher",
            thumbnailUrl = "",
            platforms = listOf(Platform.BROWSER, Platform.XBOX, Platform.PLAY_STATION),
            shortDescription = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, " +
                "sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. " +
                "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi " +
                "ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit " +
                "in voluptate velit esse cillum dolore eu fugiat nulla pariatur. " +
                "Excepteur sint occaecat cupidatat non proident, " +
                "sunt in culpa qui officia deserunt mollit anim id est laborum.",
            releaseDate = LocalDate.now(),
            publisher = "",
            gameUrl = "",
            genre = Genre.UNKNOWN,
            developer = "",
        ),
        onClick = {},
    )
}
