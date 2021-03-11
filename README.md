# Kotest Extensions - Robolectric

A Kotest extension that allows you to execute tests using Robolectric.

[![master](https://github.com/kotest/kotest-extensions-robolectric/actions/workflows/master.yml/badge.svg)](https://github.com/kotest/kotest-extensions-robolectric/actions/workflows/master.yml)
[<img src="https://img.shields.io/maven-central/v/io.kotest.extensions/kotest-extensions-robolectric.svg?label=latest%20release"/>](http://search.maven.org/#search|ga|1|kotest-extensions-robolectric)
![GitHub](https://img.shields.io/github/license/kotest/kotest-extensions-robolectric)
[![kotest @ kotlinlang.slack.com](https://img.shields.io/static/v1?label=kotlinlang&message=kotest&color=blue&logo=slack)](https://kotlinlang.slack.com/archives/CT0G9SD7Z)
[<img src="https://img.shields.io/nexus/s/https/oss.sonatype.org/io.kotest.extensions/kotest-extensions-robolectric.svg?label=latest%20snapshot"/>](https://oss.sonatype.org/content/repositories/snapshots/io/kotest/extensions/kotest-extensions-robolectric/)


## Attention: Experimental
This extension might work for you, and it might not. We're still tweaking with Robolectric, and it isn't completely stable yet.

### Getting started:

Add the `io.kotest:kotest-extensions-robolectric` module to your classpath.

Then register the `RobolectricExtension` extension in your PROJECT config, as it is a `ConstructorExtension`

With that in place, mark any `Spec` with `@RobolectricTest` and you should be good to go.
