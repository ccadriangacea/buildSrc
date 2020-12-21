logger.lifecycle("\n>>> Running build.gradle.kts in buildSrc\n")

plugins {
    application

    `kotlin-dsl`
}

repositories {
    mavenLocal()
    mavenCentral()
    jcenter()

    gradlePluginPortal()

    // Needed for the kotlin allopen plugin
    maven("https://dl.bintray.com/kotlin/kotlin-dev/")
}

val kotlinPluginVersion: String by System.getProperties()
val benManesVersionsPluginVersion: String by System.getProperties()

val quarkusPluginVersion: String by System.getProperties()
val shadowPluginVersion: String by System.getProperties()

val jvmTargetVersion: String by System.getProperties()
val kotlinApiVersion: String by System.getProperties()

dependencies {
    // Kotlin plugin
    "implementation"("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinPluginVersion")

    // Dependencies update
    "implementation"("com.github.ben-manes:gradle-versions-plugin:$benManesVersionsPluginVersion")

    // Quarkus plugin + dependencies
    "implementation"("gradle.plugin.io.quarkus:quarkus-gradle-plugin:$quarkusPluginVersion")
    "implementation"("org.jetbrains.kotlin.plugin.allopen:org.jetbrains.kotlin.plugin.allopen.gradle.plugin:$kotlinPluginVersion")

    // ShadowJar
    "implementation"("com.github.jengelman.gradle.plugins:shadow:$shadowPluginVersion")
}