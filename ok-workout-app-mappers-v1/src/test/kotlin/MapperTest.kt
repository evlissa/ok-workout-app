package com.github.evlissa.ok.workout.app.mappers.v1

import org.junit.Test
import com.github.evlissa.ok.workout.app.api.v1.models.*
import com.github.evlissa.ok.workout.app.common.WrkApContext
import com.github.evlissa.ok.workout.app.common.models.*
import com.github.evlissa.ok.workout.app.common.stubs.WrkApStubs
import kotlin.test.assertEquals

class MapperTest {
    @Test
    fun fromTransport() {
        val req = TrainingCreateRequest(
            requestId = "1234",
            debug = TrainingDebug(
                mode = TrainingRequestDebugMode.STUB,
                stub = TrainingRequestDebugStubs.SUCCESS,
            ),
            training = TrainingCreateObject(
                title = "baRRe1208",
                description = "barre+stretch 80 minutes training",
                trainingIntensity = TrainingIntensity.LOW,
                visibility = TrainingVisibility.PUBLIC,
            ),
        )

        val context = WrkApContext()
        context.fromTransport(req)

        assertEquals(WrkApStubs.SUCCESS, context.stubCase)
        assertEquals(WrkApWorkMode.STUB, context.workMode)
        assertEquals("baRRe1208", context.trainingRequest.title)
        assertEquals(WrkApVisibility.VISIBLE_PUBLIC, context.trainingRequest.visibility)
        assertEquals(WrkApTrainingIntensity.LOW, context.trainingRequest.trainingIntensity)
    }

    @Test
    fun toTransport() {
        val context = WrkApContext(
            requestId = WrkApRequestId("1234"),
            command = WrkApCommand.CREATE,
            trainingResponse = WrkApTraining(
                title = "baRRe1208",
                description = "barre+stretch 80 minutes training",
                trainingIntensity = WrkApTrainingIntensity.LOW,
                visibility = WrkApVisibility.VISIBLE_PUBLIC,
            ),
            errors = mutableListOf(
                WrkApError(
                    code = "err",
                    group = "request",
                    field = "title",
                    message = "wrong title",
                )
            ),
            state = WrkApState.RUNNING,
        )

        val req = context.toTransportTraining() as TrainingCreateResponse

        assertEquals("1234", req.requestId)
        assertEquals("baRRe1208", req.training?.title)
        assertEquals("barre+stretch 80 minutes training", req.training?.description)
        assertEquals(TrainingVisibility.PUBLIC, req.training?.visibility)
        assertEquals(TrainingIntensity.LOW, req.training?.trainingIntensity)
        assertEquals(1, req.errors?.size)
        assertEquals("err", req.errors?.firstOrNull()?.code)
        assertEquals("request", req.errors?.firstOrNull()?.group)
        assertEquals("title", req.errors?.firstOrNull()?.field)
        assertEquals("wrong title", req.errors?.firstOrNull()?.message)
    }
}
