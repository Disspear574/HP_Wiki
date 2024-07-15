plugins {
    `kotlin-dsl`
}

group = "ru.disspear574.hpwiki"

dependencies {
    compileOnly(libs.android.gradle.plugin)
    compileOnly(libs.kotlin.gradle.plugin)
    implementation(libs.compose.gradle.plugin)

    // https://github.com/gradle/gradle/issues/15383
    implementation(files(libs.javaClass.superclass.protectionDomain.codeSource.location))
}

gradlePlugin {
    plugins {
        register("composeModule-plugin") {
            id = "composeModule-plugin"
            implementationClass = "ComposeModulePlugin"
        }
    }
}
