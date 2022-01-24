object Libs {

   const val kotlinVersion = "1.6.10"
   const val org = "io.kotest.extensions"
   const val artifactId = "kotest-extensions-robolectric"

   object Kotest {
      private const val version = "5.1.0"
      const val api = "io.kotest:kotest-framework-api:$version"
      const val junit5 = "io.kotest:kotest-runner-junit5-jvm:$version"
   }

   object Robolectric {
      private const val version = "4.6.1"
      const val robolectric = "org.robolectric:robolectric:$version"
   }

   object JUnit4 {
      private const val version = "4.13"
      const val junit4 = "junit:junit:$version"
   }

   object Android {
      const val compileSdkVersion = 30
      const val targetSdkVersion = 30
      const val minSdkVersion = 14
      const val androidGradlePlugin = "com.android.tools.build:gradle:7.0.4"
      const val appcompat = "androidx.appcompat:appcompat:1.3.0"
      const val material = "com.google.android.material:material:1.3.0"
      const val multidex = "androidx.multidex:multidex:2.0.1"
      const val testCore = "androidx.test:core:1.3.0"
   }

}
