package com.github.evlissa.ok.workout.app.common

import kotlinx.datetime.Instant
import com.github.evlissa.ok.workout.app.common.models.*
import com.github.evlissa.ok.workout.app.common.stubs.WrkApStubs

data class WrkApContext(
    var command: WrkApCommand = WrkApCommand.NONE,
    var state: WrkApState = WrkApState.NONE,
    val errors: MutableList<WrkApError> = mutableListOf(),

    var workMode: WrkApWorkMode = WrkApWorkMode.PROD,
    var stubCase: WrkApStubs = WrkApStubs.NONE,

    var requestId: WrkApRequestId = WrkApRequestId.NONE,
    var timeStart: Instant = Instant.NONE,
    var trainingRequest: WrkApTraining = WrkApTraining(),
    var trainingFilterRequest: WrkApTrainingFilter = WrkApTrainingFilter(),
    var trainingResponse: WrkApTraining = WrkApTraining(),
    var trainingsResponse: MutableList<WrkApTraining> = mutableListOf(),
)
