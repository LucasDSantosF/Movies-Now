plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.kotlinAndroid)
    alias(libs.plugins.compose.compiler)
    kotlin("plugin.serialization") version "1.9.0"
}

android {
    namespace = "com.lucas.moviesnow.android"
    compileSdk = 35
    defaultConfig {
        applicationId = "com.lucas.moviesnow.android"
        minSdk = 33
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"
    }
    buildFeatures {
        compose = true
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(projects.shared)
    implementation(libs.compose.ui)
    implementation(libs.compose.ui.tooling.preview)
    implementation(libs.compose.material3)
    implementation(libs.androidx.activity.compose)
    implementation(libs.koin.compose)
    implementation(libs.androidx.lifecycle.compose)
    implementation(libs.navigation.compose)
    implementation(libs.navigation.common)
    implementation(libs.coil.compose)
    implementation(libs.coil.network)
    implementation(libs.androidx.ui.unit.android)
    implementation(libs.androidyoutubeplayer)
    debugImplementation(libs.compose.ui.tooling)
}