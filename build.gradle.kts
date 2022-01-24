import org.gradle.api.tasks.testing.logging.TestExceptionFormat

buildscript {
   repositories {
      google()
      jcenter()
      mavenCentral()
      maven {
         url = uri("https://oss.sonatype.org/content/repositories/snapshots/")
      }
      maven {
         url = uri("https://plugins.gradle.org/m2/")
      }
   }
   dependencies {
      classpath(Libs.Android.androidGradlePlugin)
      classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${Libs.kotlinVersion}")
   }
}

plugins {
   kotlin("jvm").version(Libs.kotlinVersion)
}

tasks.named<Test>("test") {
   useJUnitPlatform()
   testLogging {
      showExceptions = true
      showStandardStreams = true
      exceptionFormat = TestExceptionFormat.FULL
   }
}

allprojects {
   group = Libs.org
   version = Ci.version

   repositories {
      google()
      mavenLocal()
      mavenCentral()
      maven {
         url = uri("https://oss.sonatype.org/content/repositories/snapshots")
      }
   }

   tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
      kotlinOptions {
         freeCompilerArgs = freeCompilerArgs + "-Xopt-in=kotlin.RequiresOptIn"
         jvmTarget = "1.8"
         apiVersion = "1.6"
         languageVersion = "1.6"
      }
   }
}
