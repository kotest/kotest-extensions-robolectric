plugins {
   id("com.android.application")
   id("kotlin-android")
}

android {
   compileSdkVersion(Libs.Android.compileSdkVersion)

   defaultConfig {
      minSdkVersion(Libs.Android.minSdkVersion)
      targetSdkVersion(Libs.Android.targetSdkVersion)
      multiDexEnabled = true
      testInstrumentationRunner = "android.support.test.runner.AndroidJUnitRunner"
   }

   buildTypes {
      getByName("release") {
         isMinifyEnabled = false
      }
   }
   sourceSets {
      getByName("main").java.srcDirs(
         "src/main/java",
         "src/main/kotlin"
      )
      getByName("test").java.srcDirs(
         "src/test/java",
         "src/test/kotlin"
      )
   }
   testOptions {
      unitTests.all {
         it.useJUnitPlatform()
      }
      unitTests {
         isIncludeAndroidResources = true
      }
   }
   compileOptions {
      sourceCompatibility = JavaVersion.VERSION_1_8
      targetCompatibility = JavaVersion.VERSION_1_8
   }
   kotlinOptions {
      jvmTarget = JavaVersion.VERSION_1_8.toString()
   }
}

dependencies {
   // Kotlin
   implementation(kotlin("reflect"))

   // Android
   implementation(Libs.Android.appcompat)
   implementation(Libs.Android.material)
   implementation("androidx.multidex:multidex:2.0.1")
   testImplementation("androidx.test:core:1.3.0")


   // Kotest
   testImplementation(project(":extensions-robolectric"))
   implementation(Libs.Kotest.api)
   testImplementation(Libs.Kotest.junit5)

   // Robolectric
   testImplementation(Libs.Robolectric.robolectric)

   // JUnit
   testImplementation(Libs.JUnit4.junit4)
}
