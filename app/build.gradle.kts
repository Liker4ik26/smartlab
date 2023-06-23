plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id("com.google.devtools.ksp") version ("1.8.20-1.0.10")
    id("com.google.dagger.hilt.android")
    id("kotlin-parcelize")
    kotlin("kapt")
}

android {
    namespace = "com.compose.medicine.smartlab"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.compose.medicine.smartlab"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        getByName("debug") {
            buildConfigField(
                "String",
                "SMARTLAB_URL",
                "\"https://4030-109-171-32-98.ngrok-free.app/\""
            )
        }
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            buildConfigField(
                "String",
                "SMARTLAB_URL",
                "\"https://4030-109-171-32-98.ngrok-free.app/\""
            )
        }
    }

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
        kotlinOptions {
            jvmTarget = "1.8"
        }
    }

    buildFeatures {
        buildConfig = true
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.5"
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

    ksp {
        arg("compose-destinations.generateNavGraphs", "false")
    }

    kapt {
        correctErrorTypes = true
    }
}

dependencies {

    implementation(libs.moshi.kotlin)
    implementation(libs.moshi.adapters)
    implementation(libs.androidx.constraintlayout.compose)
    ksp(libs.moshi.compiler)

    implementation(libs.okhttp.client)
    implementation(libs.okhttp.logginginterceptor)

    implementation(libs.retrofit.client)
    implementation(libs.retrofit.moshi)

    implementation(libs.coil.compose)

    implementation(libs.accompanist.placeholder)

    implementation(libs.hilt)
    kapt(libs.hilt.kapt)

    implementation(libs.androidx.paging.compose)

    implementation(libs.androidx.core.ktx)
    implementation(libs.lifecycle.runtime.ktx)

    implementation(libs.compose.destinations)
    implementation(libs.hilt.viewmodel)
    ksp(libs.compose.destinations.compiler)

    implementation(libs.security)

    implementation(libs.androidx.splashscreen)

    implementation(libs.androidx.lifecycle.runtime.compose)
    implementation(libs.androidx.lifecycle.viewmodel)
    implementation(libs.androidx.lifecycle.viewmodel.compose)

    implementation(libs.coil.compose)

    implementation(libs.accompanist.switerefreshlayout)
    implementation(libs.accompanist.systemuicontroller)
    implementation(libs.accompanist.insets)

    implementation(libs.moshi.kotlin)
    ksp(libs.moshi.compiler)
    implementation(libs.moshi.adapters)

    implementation(libs.retrofit.client)
    implementation(libs.retrofit.moshi)

    implementation(libs.animations.core)
    implementation(libs.accomponist.navigation.material)

    implementation(libs.room.runtime)
    implementation(libs.room.ktx)
    ksp(libs.room.ksp)

    implementation(libs.okhttp.client)
    implementation(libs.okhttp.logginginterceptor)

    implementation(libs.androidx.datastore.preferences)

    implementation(libs.androidx.activity)
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.tooling.preview)
    implementation(libs.androidx.compose.material3)
    debugImplementation(libs.androidx.compose.tooling)
}