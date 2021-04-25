package io.kotest.extensions.robolectric

import io.kotest.core.extensions.ConstructorExtension
import io.kotest.core.extensions.SpecExtension
import io.kotest.core.spec.AutoScan
import io.kotest.core.spec.Spec
import kotlin.reflect.KClass
import kotlin.reflect.full.findAnnotation

@AutoScan
class RobolectricExtension : ConstructorExtension, SpecExtension {
   private val containedRobolectricRunner = ContainedRobolectricRunner()

   override fun <T : Spec> instantiate(clazz: KClass<T>): Spec? {
      if (clazz.isNotRobolectricClass()) return null
      return containedRobolectricRunner.sdkEnvironment.bootstrappedClass<Spec>(clazz.java).newInstance()
   }

   private fun <T : Spec> KClass<T>.isNotRobolectricClass() =
      findAnnotation<RobolectricTest>() == null


   override suspend fun intercept(spec: Spec, execute: suspend (Spec) -> Unit) {
      if(spec::class.isNotRobolectricClass()) return execute(spec)
      val containedRobolectricRunner = ContainedRobolectricRunner()

      beforeSpec(containedRobolectricRunner)
      execute(spec)
      afterSpec(containedRobolectricRunner)
   }

   private fun beforeSpec(containedRobolectricRunner: ContainedRobolectricRunner) {
      Thread.currentThread().contextClassLoader = containedRobolectricRunner.sdkEnvironment.robolectricClassLoader
      containedRobolectricRunner.containedBefore()
   }

   private fun afterSpec(containedRobolectricRunner: ContainedRobolectricRunner) {
      containedRobolectricRunner.containedAfter()
      Thread.currentThread().contextClassLoader = RobolectricExtension::class.java.classLoader
   }
}

annotation class RobolectricTest
