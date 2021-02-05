import gradle.dependencies.CoreVersions
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    application

    kotlin("jvm")

    id("testing.junit-conventions")
}

repositories {
    mavenLocal()
    mavenCentral()
    jcenter()
}

kotlin {
    sourceSets {
        val main by getting {
            dependencies {
                api("org.jetbrains.kotlinx:kotlinx-coroutines-core")
                api("org.jetbrains.kotlinx:kotlinx-coroutines-jdk8")
            }
        }
        logger.debug("Loaded sourceSets dependencies: $main")
        val test by getting {
            dependencies {
                implementation("org.jetbrains.kotlin:kotlin-test-junit5")
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-test")
            }
        }
        logger.debug("Loaded sourceSets dependencies: $test")
    }
}

dependencies {
    // assure same version is loaded
    "implementation"(platform(CoreVersions.Kotlin.kotlinBom))
    "implementation"(platform(CoreVersions.Kotlin.kotlinCoroutinesBom))
}

tasks {
    withType<KotlinCompile>()
        .configureEach {
            kotlinOptions {
                jvmTarget = CoreVersions.jvmTargetVersion
                apiVersion = CoreVersions.kotlinApi
                languageVersion = CoreVersions.kotlinApi
                javaParameters = true
                freeCompilerArgs = freeCompilerArgs + "-Xopt-in=kotlin.RequiresOptIn" + "-Xinline-classes"
            }
        }

    findByName("clean")
        .apply { this?.doLast { delete(projectDir.toPath().resolve("out").toFile().absolutePath) } }
}
