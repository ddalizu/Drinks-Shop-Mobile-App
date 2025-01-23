plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.gms.google-services")
}

android {
    namespace = "com.example.apt3060"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.apt3060"
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity.ktx.v161)
    implementation(libs.constraintlayout)
    implementation(libs.recyclerview)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)

    implementation(libs.core.ktx.v190)
    implementation(libs.lifecycle.runtime.ktx.v251)
    implementation(libs.activity.compose.v151)
    implementation(platform(libs.compose.bom.v20230100))
    implementation(libs.ui.v151)
    implementation(libs.ui.graphics.v151)
    implementation(libs.ui.tooling.preview.v151)
    implementation(libs.material3.v120)

    implementation(platform(libs.firebase.bom.v3211))
    implementation(libs.google.firebase.auth)
    implementation(libs.google.firebase.firestore)
}
