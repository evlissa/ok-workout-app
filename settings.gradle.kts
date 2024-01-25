rootProject.name = "ok-workout-app-202309"

pluginManagement {
    val kotlinVersion: String by settings
    val openapiVersion: String by settings

    plugins {
        kotlin("jvm") version kotlinVersion apply false
        kotlin("plugin.serialization") version kotlinVersion apply false

        id("org.openapi.generator") version openapiVersion apply false
    }
}
plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
}

//include("m1l1-hello")
//include("ok-workout-app-acceptance")
include("ok-workout-app-api-v1-jackson")
include("ok-workout-app-common")
include("ok-workout-app-mappers-v1")

