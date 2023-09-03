plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.curso.android.app.practica.pyfinal02"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.curso.android.app.practica.pyfinal02"
        minSdk = 22
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures {
        viewBinding = true
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

        sourceCompatibility = org.gradle.api.JavaVersion.VERSION_1_8
        targetCompatibility = org.gradle.api.JavaVersion.VERSION_1_8

    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildToolsVersion = "33.0.1"

    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.10.1")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.core:core-splashscreen:1.0.1")
    //ViewModelkk
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1")
    //LiveData
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.1")
    //Fragment
    implementation("androidx.fragment:fragment-ktx:1.6.1")
    //Activity
    implementation("androidx.activity:activity-ktx:1.7.2")
    implementation("androidx.test.ext:junit-ktx:1.1.5")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.7.3")
    testImplementation("junit:junit:4.13.2")
    testImplementation("androidx.room:room-coroutines:2.1.0-alpha04")
    testImplementation ("androidx.arch.core:core-testing:2.2.0")
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.0")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation("androidx.arch.core:core-testing:2.2.0")
    androidTestImplementation ("androidx.test:runner:1.5.2")
    androidTestImplementation ("androidx.test:rules:1.5.0")
}

