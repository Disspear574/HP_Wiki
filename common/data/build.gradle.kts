plugins {
    alias(libs.plugins.composeModule.plugin)
}

android {
    namespace = "ru.disspear574.data"
}

dependencies {
    implementation(projects.common.domain)
}