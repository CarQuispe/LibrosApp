plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("org.jetbrains.kotlin.plugin.compose")
    id("com.google.devtools.ksp")
    id("com.google.dagger.hilt.android")
    id("org.jetbrains.kotlin.plugin.serialization")
    id("com.google.gms.google-services")
    kotlin("kapt")
}

android {
    namespace = "com.tuusuario.bookfinder"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.tuusuario.bookfinder"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    // Android Core
    implementation(libs.androidx.core.ktx.v1120)
    implementation(libs.androidx.lifecycle.runtime.ktx.v262)

    // Compose
    implementation(libs.androidx.compose.bom.v20231001)
    implementation(libs.ui)
    implementation(libs.ui.graphics)
    implementation(libs.ui.tooling.preview)
    implementation(libs.material3)
    implementation(libs.androidx.activity.compose.v180)
    implementation(libs.lifecycle.viewmodel.compose)
    implementation(libs.runtime.livedata)

    // Navigation
    implementation(libs.androidx.navigation.compose.v274)

    // Hilt
    implementation(libs.hilt.android.v248)
    implementation(libs.androidx.hilt.navigation.compose.v100)
    implementation(libs.androidx.material3.android)
    kapt(libs.hilt.compiler.v248)

    // Coroutines
    implementation(libs.kotlinx.coroutines.core.v173)
    implementation(libs.kotlinx.coroutines.android)

    // Coil
    implementation(libs.coil.compose.v240)

    // Firebase
    implementation(libs.firebase.messaging.ktx)

    // Serialization
    implementation(libs.kotlinx.serialization.json.v160)

    // Retrofit
    implementation(libs.retrofit)
    implementation(libs.converter.moshi)

    implementation("com.squareup.retrofit2:retrofit:2.9.0")
// Converter (si usas kotlinx.serialization o Moshi puedes cambiar este)
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")

    // Moshi
    implementation(libs.moshi.v1150)
    implementation(libs.moshi.kotlin.v1150)
    ksp(libs.moshi.kotlin.codegen.v1150)

    // Room
    implementation(libs.androidx.room.runtime.v260)
    implementation(libs.androidx.room.ktx.v260)
    ksp(libs.androidx.room.compiler.v260)

    // Testing
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit.v115)
    androidTestImplementation(libs.androidx.espresso.core.v351)
    androidTestImplementation(libs.androidx.compose.bom)
    androidTestImplementation(libs.ui.test.junit4)

    // Debug
    debugImplementation(libs.ui.tooling)
    debugImplementation(libs.ui.test.manifest)
    debugImplementation("com.squareup.leakcanary:leakcanary-android:2.12")

    // Módulos
    implementation(project(":domain"))
    implementation(project(":data"))
    implementation(project(":framework"))
}

kapt {
    correctErrorTypes = true
}