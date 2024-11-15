package com.netimur.onegames.core.utils

inline fun <I, O> List<I>.mapList(mapSingle: I.() -> O): List<O> {
    return mapNotNull { it.mapSingle() }
}
