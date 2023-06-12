plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt") // kapt 사용을 위한 설정
    kotlin("plugin.serialization") version "1.8.10"
}

android {
    namespace = "digital.patron.app_patronnativeapp"
    compileSdk = 33

    defaultConfig {
        applicationId = "digital.patron.app_patronnativeapp"
        minSdk = 21
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables.useSupportLibrary = true
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true // Enables code shrinking for the release build type.
            proguardFiles(
                getDefaultProguardFile("proguard-android.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
}

dependencies {

    val appcompatVersion = "1.6.1"
    val activityVersion = "1.6.1"
    val lifecycleVersion = "2.5.1"
    val liveDataVersion = "1.3.3"
    val material3Version = "1.0.1"
    val navVersion = "2.5.3"
    val coreVersion = "1.9.0"
    val roomVersion = "2.5.0"
    val retrofitVersion = "2.9.0"
    val gsonVersion = "2.9.0"
    val composeBom = platform("androidx.compose:compose-bom:2023.01.00")

    implementation(composeBom)
    androidTestImplementation(composeBom)

    // only import the main APIs for the underlying toolkit systems, such as input and measurement/layout
    implementation("androidx.compose.ui:ui")
    // Material Design 3
    implementation("androidx.compose.material3:material3:$material3Version")

    // 앱의 API 레벨 호환성을 해결한다.
    implementation("androidx.appcompat:appcompat:$appcompatVersion")
    // For loading and tinting drawables on older versions of the platform
    implementation("androidx.appcompat:appcompat-resources:$appcompatVersion")

    // Android Studio Preview support
    implementation("androidx.compose.ui:ui-tooling-preview")
    debugImplementation("androidx.compose.ui:ui-tooling")

    // UI Tests
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

    // Kotlin core
    implementation("androidx.core:core-ktx:$coreVersion")

    // ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycleVersion")
    // ViewModel utilities for Compose
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:$lifecycleVersion")
    // LiveData
    implementation("androidx.compose.runtime:runtime-livedata:$liveDataVersion")

    // Kotlin activity
    implementation("androidx.activity:activity-compose:$activityVersion")
    implementation("androidx.activity:activity-ktx:$activityVersion")

    // Jetpack Compose Integration
    implementation("androidx.navigation:navigation-compose:$navVersion")

    // Room
    implementation("androidx.room:room-runtime:$roomVersion")
    // To use Kotlin annotation processing tool (kapt)
    kapt("androidx.room:room-compiler:$roomVersion")
    // optional - Kotlin Extensions and Coroutines support for Room
    implementation("androidx.room:room-ktx:$roomVersion")

    // Retrofit
    implementation("com.squareup.retrofit2:retrofit:$retrofitVersion")
    // Gson
    implementation("com.squareup.retrofit2:converter-gson:$gsonVersion")

    // JSON serialization
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.5.0")

    // Inject
    implementation("javax.inject:javax.inject:1")

    // Retrofit2 kotlinx serialization converter
    implementation("com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:1.0.0")

    // okhttp3
    implementation("com.squareup.okhttp3:okhttp:4.9.1")
    implementation("com.squareup.okhttp3:logging-interceptor:4.9.1")
}