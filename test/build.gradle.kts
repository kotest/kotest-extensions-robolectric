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
   implementation(Libs.Android.multidex)
   testImplementation(Libs.Android.testCore)

   // Kotest
   testImplementation(project(":extensions-robolectric"))
   implementation(Libs.Kotest.api)
   testImplementation(Libs.Kotest.junit5)

   // Robolectric
   testImplementation(Libs.Robolectric.robolectric)

   // JUnit
   testImplementation(Libs.JUnit4.junit4)
}
