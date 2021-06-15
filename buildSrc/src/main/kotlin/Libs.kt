object Libs {

   const val kotlinVersion = "1.4.31"
   const val org = "io.kotest.extensions"
   const val artifactId = "kotest-extensions-robolectric"

   object Kotest {
      private const val version = "4.4.1"
      const val api = "io.kotest:kotest-framework-api:$version"
      const val junit5 = "io.kotest:kotest-runner-junit5-jvm:$version"
   }

   object Robolectric {
      private const val version = "4.5.1"
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
      const val appcompat = "androidx.appcompat:appcompat:1.3.0"
      const val material = "com.google.android.material:material:1.3.0"
   }

}
