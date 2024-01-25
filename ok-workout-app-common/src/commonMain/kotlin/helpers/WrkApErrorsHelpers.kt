package com.github.evlissa.ok.workout.app.common.helpers

import com.github.evlissa.ok.workout.app.common.WrkApContext
import com.github.evlissa.ok.workout.app.common.models.WrkApError

fun Throwable.asWrkApError(
    code: String = "unknown",
    group: String = "exceptions",
    message: String = this.message ?: "",
) = WrkApError(
    code = code,
    group = group,
    field = "",
    message = message,
    exception = this,
)

fun WrkApContext.addError(vararg error: WrkApError) = errors.addAll(error)
