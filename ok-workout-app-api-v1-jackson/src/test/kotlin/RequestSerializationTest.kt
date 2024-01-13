package com.github.evlissa.ok.workout.app.api.v1

import com.github.evlissa.ok.workout.app.api.v1.models.*
import kotlin.test.Test
import kotlin.test.assertContains
import kotlin.test.assertEquals

class RequestSerializationTest {
    private val request = TrainingCreateRequest(
        requestId = "123",
        debug = TrainingDebug(
            mode = TrainingRequestDebugMode.STUB,
            stub = TrainingRequestDebugStubs.BAD_TITLE
        ),
        training = TrainingCreateObject(
            title = "baRRe1208",
            description = "barre+stretch 80 minutes training",
            trainingIntensity = TrainingIntensity.LOW,
            visibility = TrainingVisibility.PUBLIC,
        )
    )

    @Test
    fun serialize() {
        val json = apiV1Mapper.writeValueAsString(request)

        assertContains(json, Regex("\"title\":\\s*\"baRRe1208\""))
        assertContains(json, Regex("\"mode\":\\s*\"stub\""))
        assertContains(json, Regex("\"stub\":\\s*\"badTitle\""))
        assertContains(json, Regex("\"requestType\":\\s*\"create\""))
    }

    @Test
    fun deserialize() {
        val json = apiV1Mapper.writeValueAsString(request)
        val obj = apiV1Mapper.readValue(json, IRequest::class.java) as TrainingCreateRequest

        assertEquals(request, obj)
    }

    @Test
    fun deserializeNaked() {
        val jsonString = """
            {"requestId": "123"}
        """.trimIndent()
        val obj = apiV1Mapper.readValue(jsonString, TrainingCreateRequest::class.java)

        assertEquals("123", obj.requestId)
    }
}
