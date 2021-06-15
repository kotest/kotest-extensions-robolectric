package io.kotest.extensions.robolectric

import java.lang.reflect.Method
import org.junit.runners.model.FrameworkMethod
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import org.robolectric.internal.bytecode.InstrumentationConfiguration
import org.robolectric.pluginapi.config.ConfigurationStrategy
import org.robolectric.plugins.ConfigConfigurer
import org.robolectric.plugins.HierarchicalConfigurationStrategy

internal class ContainedRobolectricRunner(
   private val config: Config?
) : RobolectricTestRunner(PlaceholderTest::class.java) {
   private val placeHolderMethod: FrameworkMethod = children[0]
   val sdkEnvironment = getSandbox(placeHolderMethod).also {
      configureSandbox(it, placeHolderMethod)
   }
   private val bootStrapMethod = sdkEnvironment.bootstrappedClass<Any>(testClass.javaClass)
      .getMethod(PlaceholderTest::bootStrapMethod.name)

   fun containedBefore() {
      super.beforeTest(sdkEnvironment, placeHolderMethod, bootStrapMethod)
   }

   fun containedAfter() {
      super.afterTest(placeHolderMethod, bootStrapMethod)
      super.finallyAfterTest(placeHolderMethod)
   }

   override fun createClassLoaderConfig(method: FrameworkMethod?): InstrumentationConfiguration {
      return InstrumentationConfiguration.Builder(super.createClassLoaderConfig(method))
         .doNotAcquirePackage("io.kotest")
         .build()
   }

   override fun getConfiguration(method: Method?): ConfigurationStrategy.Configuration {
      val defaultConfiguration =
         super.getConfiguration(method) as HierarchicalConfigurationStrategy.ConfigurationImpl

      if (config != null) {
         val configConfigurer = defaultInjector().build().getInstance(ConfigConfigurer::class.java)
         val newConfig = configConfigurer.merge(defaultConfiguration[Config::class.java], config)

         defaultConfiguration.put(Config::class.java, newConfig)
      }

      return defaultConfiguration
   }

   class PlaceholderTest {
      @org.junit.Test
      fun testPlaceholder() {
      }

      fun bootStrapMethod() {
      }
   }
}
