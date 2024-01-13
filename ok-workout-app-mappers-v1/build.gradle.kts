plugins {
    kotlin("jvm")
}

group = rootProject.group
version = rootProject.version

dependencies {
    implementation(kotlin("stdlib"))
    implementation(project(":ok-workout-app-api-v1-jackson"))
    implementation(project(":ok-workout-app-common"))

    testImplementation(kotlin("test-junit"))
}