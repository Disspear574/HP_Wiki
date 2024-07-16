plugins {
    alias(libs.plugins.composeModule.plugin)
}

android {
    namespace = "ru.disspear574.domain"
}
dependencies {
    implementation(libs.koin.core)
}
