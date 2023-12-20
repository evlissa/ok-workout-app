package com.github.evlissa.ok.workout.app.blackbox.test.action.v1

import io.kotest.assertions.withClue
import io.kotest.matchers.should
import com.github.evlissa.ok.workout.app.blackbox.fixture.client.Client

suspend fun Client.createAd(): Unit =
    withClue("createAdV1") {
        val response = sendAndReceive(
            "ad/create", """
                {
                    "name": "Bolt"
                }
            """.trimIndent()
        )

        response should haveNoErrors
    }
