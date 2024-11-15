package com.netimur.onegames.core.coroutines

import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

object OneGamesRestCoroutineContext {
    val context: CoroutineContext = Dispatchers.IO + OneGamesCoroutineExceptionHandler()
}
