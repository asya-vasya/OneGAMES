package com.netimur.onegames

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.netimur.onegames.feature.gamedetails.GameDetailsScreen
import com.netimur.onegames.feature.gamedetails.GameDetailsViewModel
import com.netimur.onegames.feature.gameslist.GamesListScreen
import com.netimur.onegames.feature.gameslist.GamesListViewModel
import com.netimur.onegames.navigation.GameDetails
import com.netimur.onegames.navigation.GamesList
import com.netimur.onegames.ui.theme.ONEGamesTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val gamesListViewModel: GamesListViewModel by viewModels()
        val gameDetailsViewModel: GameDetailsViewModel by viewModels()

        setContent {
            val navController = rememberNavController()

            ONEGamesTheme {
                NavHost(navController = navController, startDestination = GamesList) {
                    composable<GamesList> {
                        GamesListScreen(
                            navigateToDetailsScreen = { gameId, gameName ->
                                navController.navigate(
                                    GameDetails(
                                        gameId = gameId,
                                        gameName = gameName,
                                    ),
                                )
                            },
                            viewModel = gamesListViewModel,
                        )
                    }

                    composable<GameDetails> { backStackEntry ->
                        val gameDetailsRoute = backStackEntry.toRoute<GameDetails>()
                        GameDetailsScreen(
                            onBack = navController::popBackStack,
                            gameId = gameDetailsRoute.gameId,
                            gameName = gameDetailsRoute.gameName,
                            viewModel = gameDetailsViewModel,
                        )
                    }
                }
            }
        }
    }
}
