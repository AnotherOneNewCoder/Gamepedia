rootProject.name = "Gamepedia"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
    plugins {
        kotlin("jvm") version "2.0.21"
    }
}

dependencyResolutionManagement {
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}

include(":composeApp")
include(":core-database")
include(":core-network")
include(":core-uikit")

include(":search:data")
include(":search:domain")
include(":search:presentation")

include(":game:data")
include(":game:domain")
include(":game:presentation")

include(":favorite:data")
include(":favorite:domain")
include(":favorite:presentation")

include(":common:data")
include(":common:domain")
include(":common:presentation")