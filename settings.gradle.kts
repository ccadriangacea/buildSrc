logger.lifecycle("\n>>> Running settings.gradle.kts in buildSrc\n")

rootProject.name = "buildSrc"

pluginManagement {
    repositories {
        mavenLocal()
        mavenCentral()
        gradlePluginPortal()
    }
}