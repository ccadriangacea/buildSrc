import gradle.dependencies.Versions
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    application

    kotlin("jvm")
    kotlin("kapt")

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
    "implementation"(platform(Versions.Kotlin.kotlinBom))
    "implementation"(platform(Versions.Kotlin.kotlinCoroutinesBom))
}

tasks {
    withType<KotlinCompile>()
        .configureEach {
            kotlinOptions {
                jvmTarget = Versions.jvmTargetVersion
                apiVersion = Versions.kotlinApi
                languageVersion = Versions.kotlinApi
                javaParameters = true
                freeCompilerArgs = freeCompilerArgs + "-Xopt-in=kotlin.RequiresOptIn"
            }
        }

    findByName("clean")
        .apply { this?.doLast { delete(project.projectDir.toPath().resolve("out").toFile().absolutePath) } }
}
