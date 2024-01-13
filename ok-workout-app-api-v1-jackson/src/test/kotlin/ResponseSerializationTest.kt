package com.github.evlissa.ok.workout.app.api.v1

import com.github.evlissa.ok.workout.app.api.v1.models.*
import kotlin.test.Test
import kotlin.test.assertContains
import kotlin.test.assertEquals

class ResponseSerializationTest {
    private val response = TrainingCreateResponse(
        requestId = "123",
        training = TrainingResponseObject(
            title = "baRRe1208",
            description = "barre+stretch 80 minutes training",
            trainingIntensity = TrainingIntensity.LOW,
            visibility = TrainingVisibility.PUBLIC,
        )
    )

    @Test
    fun serialize() {
        val json = apiV1Mapper.writeValueAsString(response)

        assertContains(json, Regex("\"title\":\\s*\"baRRe1208\""))
        assertContains(json, Regex("\"responseType\":\\s*\"create\""))
    }

    @Test
    fun deserialize() {
        val json = apiV1Mapper.writeValueAsString(response)
        val obj = apiV1Mapper.readValue(json, IResponse::class.java) as TrainingCreateResponse

        assertEquals(response, obj)
    }
}
