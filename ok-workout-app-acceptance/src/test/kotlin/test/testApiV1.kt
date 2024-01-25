package com.github.evlissa.ok.workout.app.blackbox.test

import io.kotest.core.spec.style.FunSpec
import com.github.evlissa.ok.workout.app.blackbox.fixture.client.Client
import com.github.evlissa.ok.workout.app.blackbox.test.action.v1.createAd

fun FunSpec.testApiV1(client: Client) {
    context("v1") {
        test("Create training ok") {
            client.createTraining()
        }
    }
}