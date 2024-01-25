package com.github.evlissa.ok.workout.app.common.models

data class WrkApTraining(
    var id: WrkApTrainingId = WrkApTrainingId.NONE,
    var title: String = "",
    var description: String = "",
    var ownerId: WrkApUserId = WrkApUserId.NONE,
    var trainingIntensity: WrkApTrainingIntensity = WrkApTrainingIntensity.NONE,
    var visibility: WrkApVisibility = WrkApVisibility.NONE,
    var planId: WrkApPlanId = WrkApPlanId.NONE,
    val permissionsClient: MutableSet<WrkApTrainingPermissionClient> = mutableSetOf()
)
