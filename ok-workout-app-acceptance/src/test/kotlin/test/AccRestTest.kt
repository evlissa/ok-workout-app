package com.github.evlissa.ok.workout.app.blackbox.test

import fixture.client.RestClient
import io.kotest.core.annotation.Ignored
import com.github.evlissa.ok.workout.app.blackbox.docker.WiremockDockerCompose
import com.github.evlissa.ok.workout.app.blackbox.fixture.BaseFunSpec
import com.github.evlissa.ok.workout.app.blackbox.fixture.docker.DockerCompose

@Ignored
open class AccRestTestBase(dockerCompose: DockerCompose) : BaseFunSpec(dockerCompose, {
    val client = RestClient(dockerCompose)

    testApiV1(client)
})
class AccRestWiremockTest : AccRestTestBase(WiremockDockerCompose)
// TODO class AccRestSpringTest : AccRestTestBase(SpringDockerCompose)
// TODO class AccRestKtorTest : AccRestTestBase(KtorDockerCompose)
