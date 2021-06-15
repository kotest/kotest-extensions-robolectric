plugins {
   id("com.android.library")
   id("kotlin-android")
}

android {
   compileSdkVersion(30)

   defaultConfig {
      minSdkVersion(14)
      targetSdkVersion(30)

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

   // Kotest
   implementation(Libs.Kotest.api)
   testImplementation(Libs.Kotest.junit5)

   // Robolectric
   implementation(Libs.Robolectric.robolectric)

   // JUnit
   implementation(Libs.JUnit4.junit4)
}

apply("./publish.gradle.kts")
