import org.jetbrains.compose.desktop.application.dsl.TargetFormat


plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
    //alias(libs.plugins.composeHotReload)
    alias(libs.plugins.sql.delight)
}

kotlin {
    androidTarget {
//        @OptIn(ExperimentalKotlinGradlePluginApi::class)
//        compilerOptions {
//            jvmTarget.set(JvmTarget.JVM_11)
//        }
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
//            baseName = "ComposeApp"
//            isStatic = true
        }
    }

    jvm("desktop")

    sourceSets {
        val desktopMain by getting

        androidMain.dependencies {
            implementation(compose.preview)
            implementation(libs.androidx.activity.compose)
            implementation(libs.sql.delight.android)
        }
        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material3)
            implementation(compose.ui)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)
            implementation(libs.androidx.lifecycle.viewmodel)
            implementation(libs.androidx.lifecycle.runtimeCompose)
            implementation(libs.sql.delight.common)
            api(libs.sql.delight.common.coroutines)
            implementation(libs.koin.core)
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
        desktopMain.dependencies {
            implementation(compose.desktop.currentOs)
            implementation(libs.kotlinx.coroutinesSwing)
            implementation(libs.sql.delight.desktop)
            api(libs.sql.delight.common.coroutines)
        }
        iosMain.dependencies {
            implementation(libs.sql.delight.ios)
        }
    }
}

sqldelight{
    databases{
        create("AppDatabase") {
            packageName.set("com.zhogin.core.database")
            srcDirs("src/commonMain/sqldelight")
//            generateAsync.set(true)
        }
    }
    linkSqlite = true
}

android {
    namespace = "com.zhogin.core.database"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    defaultConfig {

        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.targetSdk.get().toInt()

    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    debugImplementation(compose.uiTooling)
}

compose.desktop {
    application {

        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "com.zhogin.core.database"
            packageVersion = "1.0.0"
        }
    }
}
