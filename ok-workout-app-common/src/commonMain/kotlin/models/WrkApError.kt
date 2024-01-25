package com.github.evlissa.ok.workout.app.common.models

data class WrkApError(
    val code: String = "",
    val group: String = "",
    val field: String = "",
    val message: String = "",
    val exception: Throwable? = null,
)
