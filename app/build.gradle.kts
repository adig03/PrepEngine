plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("kotlin-kapt")
    alias(libs.plugins.google.gms.google.services)
    id("androidx.navigation.safeargs.kotlin")
}

android {
    namespace = "com.example.codemastery"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.codemastery"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }

    buildFeatures {
        dataBinding = true
        viewBinding = true // Added view binding
    }

    packagingOptions {
        exclude("META-INF/DEPENDENCIES") // Added to avoid packaging conflicts
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material) // Ensure you have only one material dependency
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.firebase.auth)
    implementation(libs.firebase.firestore)
    implementation(libs.firebase.analytics)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    // Splash screen activity
    implementation("androidx.core:core-splashscreen:1.0.0")
    implementation("com.airbnb.android:lottie:6.5.1")

    // Retrofit and Gson converter implementation
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")

    // Kotlin coroutine implementation
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")

    val lifecycle_version = "2.8.6" // Check for the latest version
    val nav_version = "2.8.1" // Check for the latest version
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_version")
    kapt("androidx.lifecycle:lifecycle-compiler:$lifecycle_version")

    implementation("androidx.navigation:navigation-fragment:$nav_version")
    implementation("androidx.navigation:navigation-ui:$nav_version")

    // Circle image view
    implementation("de.hdodenhof:circleimageview:3.1.0")

    // Glide for image loading
    implementation("com.github.bumptech.glide:glide:4.16.0")
    kapt("com.github.bumptech.glide:compiler:4.16.0")

    // Google sign-in and YouTube API
    implementation("com.google.android.gms:play-services-auth:20.7.0")
    implementation("com.google.apis:google-api-services-youtube:v3-rev20210915-1.32.1")
}
