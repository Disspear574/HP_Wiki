plugins {
    alias(libs.plugins.composeModule.plugin)
}

android {
    namespace = "ru.disspear574.components"
}

dependencies {
    api(libs.coil)
    implementation(libs.koin.core)
    implementation(libs.koin.compose)
}
