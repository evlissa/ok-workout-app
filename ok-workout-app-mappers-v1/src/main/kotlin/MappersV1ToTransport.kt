package com.github.evlissa.ok.workout.app.mappers.v1

import com.github.evlissa.ok.workout.app.api.v1.models.*
import com.github.evlissa.ok.workout.app.common.WrkApContext
import com.github.evlissa.ok.workout.app.common.models.*
import com.github.evlissa.ok.workout.app.mappers.v1.exceptions.UnknownWrkApCommand

fun WrkApContext.toTransportTraining(): IResponse = when (val cmd = command) {
    WrkApCommand.CREATE -> toTransportCreate()
    WrkApCommand.READ -> toTransportRead()
    WrkApCommand.UPDATE -> toTransportUpdate()
    WrkApCommand.DELETE -> toTransportDelete()
    WrkApCommand.SEARCH -> toTransportSearch()
    WrkApCommand.PLAN -> toTransportPlan()
    WrkApCommand.NONE -> throw UnknownWrkApCommand(cmd)
}

fun WrkApContext.toTransportCreate() = TrainingCreateResponse(
    responseType = "create",
    requestId = this.requestId.asString().takeIf { it.isNotBlank() },
    result = if (state == WrkApState.RUNNING) ResponseResult.SUCCESS else ResponseResult.ERROR,
    errors = errors.toTransportErrors(),
    training = trainingResponse.toTransportTraining()
)

fun WrkApContext.toTransportRead() = TrainingReadResponse(
    responseType = "read",
    requestId = this.requestId.asString().takeIf { it.isNotBlank() },
    result = if (state == WrkApState.RUNNING) ResponseResult.SUCCESS else ResponseResult.ERROR,
    errors = errors.toTransportErrors(),
    training = trainingResponse.toTransportTraining()
)

fun WrkApContext.toTransportUpdate() = TrainingUpdateResponse(
    responseType = "update",
    requestId = this.requestId.asString().takeIf { it.isNotBlank() },
    result = if (state == WrkApState.RUNNING) ResponseResult.SUCCESS else ResponseResult.ERROR,
    errors = errors.toTransportErrors(),
    training = trainingResponse.toTransportTraining()
)

fun WrkApContext.toTransportDelete() = TrainingDeleteResponse(
    responseType = "delete",
    requestId = this.requestId.asString().takeIf { it.isNotBlank() },
    result = if (state == WrkApState.RUNNING) ResponseResult.SUCCESS else ResponseResult.ERROR,
    errors = errors.toTransportErrors(),
    training = trainingResponse.toTransportTraining()
)

fun WrkApContext.toTransportSearch() = TrainingSearchResponse(
    responseType = "search",
    requestId = this.requestId.asString().takeIf { it.isNotBlank() },
    result = if (state == WrkApState.RUNNING) ResponseResult.SUCCESS else ResponseResult.ERROR,
    errors = errors.toTransportErrors(),
    trainings = trainingsResponse.toTransportTraining()
)

fun WrkApContext.toTransportPlan() = TrainingPlanResponse(
    responseType = "plan",
    requestId = this.requestId.asString().takeIf { it.isNotBlank() },
    result = if (state == WrkApState.RUNNING) ResponseResult.SUCCESS else ResponseResult.ERROR,
    errors = errors.toTransportErrors(),
    trainings = trainingsResponse.toTransportTraining()
)

fun List<WrkApTraining>.toTransportTraining(): List<TrainingResponseObject>? = this
    .map { it.toTransportTraining() }
    .toList()
    .takeIf { it.isNotEmpty() }

fun WrkApContext.toTransportInit() = TrainingInitResponse(
    requestId = this.requestId.asString().takeIf { it.isNotBlank() },
    result = if (errors.isEmpty()) ResponseResult.SUCCESS else ResponseResult.ERROR,
    errors = errors.toTransportErrors(),
)

private fun WrkApTraining.toTransportTraining(): TrainingResponseObject = TrainingResponseObject(
    id = id.takeIf { it != WrkApTrainingId.NONE }?.asString(),
    title = title.takeIf { it.isNotBlank() },
    description = description.takeIf { it.isNotBlank() },
    ownerId = ownerId.takeIf { it != WrkApUserId.NONE }?.asString(),
    trainingIntensity = trainingIntensity.toTransportTraining(),
    visibility = visibility.toTransportTraining(),
    permissions = permissionsClient.toTransportTraining(),
)

private fun Set<WrkApTrainingPermissionClient>.toTransportTraining(): Set<TrainingPermissions>? = this
    .map { it.toTransportTraining() }
    .toSet()
    .takeIf { it.isNotEmpty() }

private fun WrkApTrainingPermissionClient.toTransportTraining() = when (this) {
    WrkApTrainingPermissionClient.READ -> TrainingPermissions.READ
    WrkApTrainingPermissionClient.UPDATE -> TrainingPermissions.UPDATE
    WrkApTrainingPermissionClient.MAKE_VISIBLE_OWNER -> TrainingPermissions.MAKE_VISIBLE_OWN
    WrkApTrainingPermissionClient.MAKE_VISIBLE_GROUP -> TrainingPermissions.MAKE_VISIBLE_GROUP
    WrkApTrainingPermissionClient.MAKE_VISIBLE_PUBLIC -> TrainingPermissions.MAKE_VISIBLE_PUBLIC
    WrkApTrainingPermissionClient.DELETE -> TrainingPermissions.DELETE
}

private fun WrkApVisibility.toTransportTraining(): TrainingVisibility? = when (this) {
    WrkApVisibility.VISIBLE_PUBLIC -> TrainingVisibility.PUBLIC
    WrkApVisibility.VISIBLE_TO_GROUP -> TrainingVisibility.REGISTERED_ONLY
    WrkApVisibility.VISIBLE_TO_OWNER -> TrainingVisibility.OWNER_ONLY
    WrkApVisibility.NONE -> null
}

private fun WrkApTrainingIntensity.toTransportTraining(): TrainingIntensity? = when (this) {
    WrkApTrainingIntensity.LOW -> TrainingIntensity.LOW
    WrkApTrainingIntensity.MEDIUM -> TrainingIntensity.MEDIUM
    WrkApTrainingIntensity.HIGH -> TrainingIntensity.HIGH
    WrkApTrainingIntensity.NONE -> null
}

private fun List<WrkApError>.toTransportErrors(): List<Error>? = this
    .map { it.toTransportTraining() }
    .toList()
    .takeIf { it.isNotEmpty() }

private fun WrkApError.toTransportTraining() = Error(
    code = code.takeIf { it.isNotBlank() },
    group = group.takeIf { it.isNotBlank() },
    field = field.takeIf { it.isNotBlank() },
    message = message.takeIf { it.isNotBlank() },
)
