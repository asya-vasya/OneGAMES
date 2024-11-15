package com.netimur.onegames.feature.gamedetails.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.netimur.onegames.core.designsystem.Spaces
import com.netimur.onegames.data.games.model.GameDetails
import com.netimur.onegames.ui.theme.basic_color
import com.netimur.onegames.ui.theme.text_color


@Composable
fun DetailsContent(
    gameDetails: GameDetails,
    isTextCollapsed: Boolean,
    expandDescription: ()->Unit,
    collapsDescription: ()->Unit,

     ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = basic_color)
    ){      Column {
            GameThumbnail(gameDetails)
            Spacer(modifier = Modifier.height(20.dp))
            Row {
                Column (modifier = Modifier.verticalScroll(rememberScrollState())
                ) {
                    Text(
                        text = gameDetails.title,
                        fontSize = 30.sp,
                        color = text_color,
                        modifier = Modifier.padding(all = Spaces.xs)
                    )
                    Row {
                        Text(text = "Genre:",
                            color = text_color,
                            modifier = Modifier.padding(all = Spaces.xs))
                        Card {
                            Text(
                                text = gameDetails.status.toString(),
                                color = basic_color,
                                modifier = Modifier.padding(all = Spaces.xs)
                            )
                        }
                    }

                    if (isTextCollapsed) {
                        Text(
                            text = gameDetails.shortDescription,
                            color = text_color,
                            modifier = Modifier.padding(all = Spaces.xs)
                        )
                    } else {
                        Text(
                            text = gameDetails.description,
                            color = text_color,
                            modifier = Modifier.padding(all = Spaces.xs)
                        )
                    }
                    Text(text = if (isTextCollapsed) "read more" else "collapse text",
                        color = text_color,
                        textDecoration = TextDecoration.Underline,
                        modifier = Modifier
                            .clickable {
                                if(isTextCollapsed){
                                    expandDescription()
                                } else {
                                    collapsDescription()
                                }
                            }
                            .padding(all = Spaces.xs)
                    )
                }
            }
        }
    }
}