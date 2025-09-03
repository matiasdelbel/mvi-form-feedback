enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    includeBuild("build-logic")

    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {

    @Suppress("UnstableApiUsage")
    repositories {
        google()
        mavenCentral()
    }
}

include(":app")
include(":mvi")
include(":design-system")
include(":review-form")
