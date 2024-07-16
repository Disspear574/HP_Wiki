rootProject.name = "HP_Wiki"

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    includeBuild("build-logic")

    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
@Suppress("UnstableApiUsage")
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

include(":app")
include(":common:data")
include(":common:domain")
include(":common:core:core-di")
include(":common:core:core-utils")
include(":common:core:compose-ui:components")
include(":common:core:compose-ui:theme")
include(":common:core:network")
include(":common:core:database")

include(":common:feature:root")
include(":common:feature:splash")
include(":common:feature:main:books")
include(":common:feature:main:characters")
