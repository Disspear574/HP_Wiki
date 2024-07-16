plugins {
    alias(libs.plugins.composeModule.plugin)
    alias(libs.plugins.kotlinx.serialization)
}

android {
    namespace = "ru.disspear574.network"
}

dependencies {
    implementation(libs.ktor.client.core)
    implementation(libs.ktor.client.logging)
    implementation(libs.ktor.serialization.kotlinx.json)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.ktor.client.okhttp)
    implementation(libs.ktor.client.content.negotiation)
    implementation(libs.koin.core)
}
