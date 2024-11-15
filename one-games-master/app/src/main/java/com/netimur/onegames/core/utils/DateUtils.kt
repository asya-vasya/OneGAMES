package com.netimur.onegames.core.utils

import java.time.LocalDate
import java.time.format.DateTimeParseException

fun String.toLocalDateOrNull(): LocalDate? {
    return try {
        LocalDate.parse(this)
    } catch (e: DateTimeParseException) {
        null
    }
}
