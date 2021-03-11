object Libs {

   const val kotlinVersion = "1.4.31"
   const val org = "io.kotest"

   object Kotest {
      private const val version = "4.4.1"
      const val api = "io.kotest:kotest-framework-api:$version"
      const val junit5 = "io.kotest:kotest-runner-junit5-jvm:$version"
   }

   object Robolectric {
      private const val version = "4.4"
      const val robolectric = "org.robolectric:robolectric:$version"
   }

   object JUnit4 {
      private const val version = "4.13"
      const val junit4 = "junit:junit:$version"
   }

}
