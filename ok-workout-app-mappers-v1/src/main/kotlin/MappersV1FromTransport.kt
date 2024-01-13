package com.github.evlissa.ok.workout.app.mappers.v1

import com.github.evlissa.ok.workout.app.api.v1.models.*
import com.github.evlissa.ok.workout.app.common.WrkApContext
import com.github.evlissa.ok.workout.app.common.models.*
import com.github.evlissa.ok.workout.app.common.stubs.WrkApStubs
import com.github.evlissa.ok.workout.app.mappers.v1.exceptions.UnknownRequestClass

fun WrkApContext.fromTransport(request: IRequest) = when (request) {
    is TrainingCreateRequest -> fromTransport(request)
    is TrainingReadRequest -> fromTransport(request)
    is TrainingUpdateRequest -> fromTransport(request)
    is TrainingDeleteRequest -> fromTransport(request)
    is TrainingSearchRequest -> fromTransport(request)
    is TrainingPlanRequest -> fromTransport(request)
    else -> throw UnknownRequestClass(request.javaClass)
}

private fun String?.toTrainingId() = this?.let { WrkApTrainingId(it) } ?: WrkApTrainingId.NONE
private fun String?.toTrainingWithId() = WrkApTraining(id = this.toTrainingId())
private fun IRequest?.requestId() = this?.requestId?.let { WrkApRequestId(it) } ?: WrkApRequestId.NONE

private fun TrainingDebug?.transportToWorkMode(): WrkApWorkMode = when (this?.mode) {
    TrainingRequestDebugMode.PROD -> WrkApWorkMode.PROD
    TrainingRequestDebugMode.TEST -> WrkApWorkMode.TEST
    TrainingRequestDebugMode.STUB -> WrkApWorkMode.STUB
    null -> WrkApWorkMode.PROD
}

private fun TrainingDebug?.transportToStubCase(): WrkApStubs = when (this?.stub) {
    TrainingRequestDebugStubs.SUCCESS -> WrkApStubs.SUCCESS
    TrainingRequestDebugStubs.NOT_FOUND -> WrkApStubs.NOT_FOUND
    TrainingRequestDebugStubs.BAD_ID -> WrkApStubs.BAD_ID
    TrainingRequestDebugStubs.BAD_TITLE -> WrkApStubs.BAD_TITLE
    TrainingRequestDebugStubs.BAD_DESCRIPTION -> WrkApStubs.BAD_DESCRIPTION
    TrainingRequestDebugStubs.BAD_VISIBILITY -> WrkApStubs.BAD_VISIBILITY
    TrainingRequestDebugStubs.BAD_INTENSITY -> WrkApStubs.BAD_INTENSITY
    TrainingRequestDebugStubs.CANNOT_DELETE -> WrkApStubs.CANNOT_DELETE
    TrainingRequestDebugStubs.BAD_SEARCH_STRING -> WrkApStubs.BAD_SEARCH_STRING
    null -> WrkApStubs.NONE
}

fun WrkApContext.fromTransport(request: TrainingCreateRequest) {
    command = WrkApCommand.CREATE
    requestId = request.requestId()
    trainingRequest = request.training?.toInternal() ?: WrkApTraining()
    workMode = request.debug.transportToWorkMode()
    stubCase = request.debug.transportToStubCase()
}

fun WrkApContext.fromTransport(request: TrainingReadRequest) {
    command = WrkApCommand.READ
    requestId = request.requestId()
    trainingRequest = request.training?.id.toTrainingWithId()
    workMode = request.debug.transportToWorkMode()
    stubCase = request.debug.transportToStubCase()
}

fun WrkApContext.fromTransport(request: TrainingUpdateRequest) {
    command = WrkApCommand.UPDATE
    requestId = request.requestId()
    trainingRequest = request.training?.toInternal() ?: WrkApTraining()
    workMode = request.debug.transportToWorkMode()
    stubCase = request.debug.transportToStubCase()
}

fun WrkApContext.fromTransport(request: TrainingDeleteRequest) {
    command = WrkApCommand.DELETE
    requestId = request.requestId()
    trainingRequest = request.training?.id.toTrainingWithId()
    workMode = request.debug.transportToWorkMode()
    stubCase = request.debug.transportToStubCase()
}

fun WrkApContext.fromTransport(request: TrainingSearchRequest) {
    command = WrkApCommand.SEARCH
    requestId = request.requestId()
    trainingFilterRequest = request.trainingFilter.toInternal()
    workMode = request.debug.transportToWorkMode()
    stubCase = request.debug.transportToStubCase()
}

fun WrkApContext.fromTransport(request: TrainingPlanRequest) {
    command = WrkApCommand.PLAN
    requestId = request.requestId()
    trainingRequest = request.training?.id.toTrainingWithId()
    workMode = request.debug.transportToWorkMode()
    stubCase = request.debug.transportToStubCase()
}

private fun TrainingSearchFilter?.toInternal(): WrkApTrainingFilter = WrkApTrainingFilter(
    searchString = this?.searchString ?: ""
)

private fun TrainingCreateObject.toInternal(): WrkApTraining = WrkApTraining(
    title = this.title ?: "",
    description = this.description ?: "",
    trainingIntensity = this.trainingIntensity.fromTransport(),
    visibility = this.visibility.fromTransport(),
)

private fun TrainingUpdateObject.toInternal(): WrkApTraining = WrkApTraining(
    id = this.id.toTrainingId(),
    title = this.title ?: "",
    description = this.description ?: "",
    trainingIntensity = this.trainingIntensity.fromTransport(),
    visibility = this.visibility.fromTransport(),
)

private fun TrainingVisibility?.fromTransport(): WrkApVisibility = when (this) {
    TrainingVisibility.PUBLIC -> WrkApVisibility.VISIBLE_PUBLIC
    TrainingVisibility.OWNER_ONLY -> WrkApVisibility.VISIBLE_TO_OWNER
    TrainingVisibility.REGISTERED_ONLY -> WrkApVisibility.VISIBLE_TO_GROUP
    null -> WrkApVisibility.NONE
}

private fun TrainingIntensity?.fromTransport(): WrkApTrainingIntensity = when (this) {
    TrainingIntensity.LOW -> WrkApTrainingIntensity.LOW
    TrainingIntensity.MEDIUM -> WrkApTrainingIntensity.MEDIUM
    TrainingIntensity.HIGH -> WrkApTrainingIntensity.HIGH
    null -> WrkApTrainingIntensity.NONE
}

