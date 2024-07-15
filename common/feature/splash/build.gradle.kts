plugins {
    alias(libs.plugins.composeModule.plugin)
}

android {
    namespace = "ru.disspear574.presentation.splash"
}

dependencies {
    implementation(projects.common.core.coreUtils)
}