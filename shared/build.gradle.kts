import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.apollo)
    kotlin("plugin.serialization") version "1.9.0"
}

kotlin {
    androidTarget {
        compilations.all {
            compileTaskProvider.configure {
                compilerOptions {
                    jvmTarget.set(JvmTarget.JVM_1_8)
                }
            }
        }
    }
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
            isStatic = true
        }
    }

    sourceSets {
        commonMain.dependencies {
            implementation(libs.apollo.runtime)
            implementation(libs.coroutines.core)
            implementation(libs.androidx.lifecycle.viewmodel)
            implementation(libs.koin.core)
            implementation(libs.koin.viewmodel)
            implementation(libs.serialization.json)
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }
}

apollo {
    service("service") {
        packageName.set("com.lucas.moviesnow")
        schemaFile.set(file("src/commonMain/graphql/schema.graphqls"))
    }
}

android {
    namespace = "com.lucas.moviesnow"
    compileSdk = 35
    defaultConfig {
        minSdk = 33
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}
dependencies {
    implementation(libs.koin.android)
}
