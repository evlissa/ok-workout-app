package com.github.evlissa.ok.workout.app.common.helpers

import com.github.evlissa.ok.workout.app.common.WrkApContext
import com.github.evlissa.ok.workout.app.common.models.WrkApCommand

fun WrkApContext.isUpdatableCommand() =
    this.command in listOf(WrkApCommand.CREATE, WrkApCommand.UPDATE, WrkApCommand.DELETE)
