package com.github.evlissa.ok.workout.app.common.models

data class WrkApTrainingFilter(
    var searchString: String = "",
    var ownerId: WrkApUserId = WrkApUserId.NONE,
    var trainingIntensity: WrkApTrainingIntensity = WrkApTrainingIntensity.NONE,
)
