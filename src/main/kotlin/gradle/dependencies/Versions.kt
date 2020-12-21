package gradle.dependencies

object Versions {
    const val kotlinApi = "1.4"
    const val jvmTargetVersion = "15"

    object Kotlin {
        const val version = "1.4.21"
        private const val kotlinCoroutines = "1.4.2"

        const val kotlinBom = "org.jetbrains.kotlin:kotlin-bom:$version"
        const val kotlinCoroutinesBom = "org.jetbrains.kotlinx:kotlinx-coroutines-bom:$kotlinCoroutines"

        const val reflect = "org.jetbrains.kotlin:kotlin-reflect:$version"
    }

    object Vertx {
        const val version = "4.0.0"
        const val nettyVersion = "4.1.54.Final"
        const val jsonVersion = "2.12.0-rc2"

        val coreDependencies: List<String> = listOf(
            "io.vertx:vertx-core:$version",
            "io.vertx:vertx-lang-kotlin:$version",
            "io.vertx:vertx-lang-kotlin-coroutines:$version"
        )

        val configDependencies: List<String> = listOf(
            "io.vertx:vertx-config:$version",
            "com.fasterxml.jackson.module:jackson-module-kotlin:$jsonVersion",
            "com.fasterxml.jackson.module:jackson-module-paranamer:$jsonVersion"
        )

        val jwtDepdendencies: List<String> = listOf(
            "io.vertx:vertx-auth-common:$version",
            "io.vertx:vertx-auth-jwt:$version"
        )

        val oauth2Dependencies: List<String> = listOf(
            "io.vertx:vertx-auth-common:$version",
            "io.vertx:vertx-auth-oauth2:$version"
        )

        const val serviceDiscoveryDependencies = "io.vertx:vertx-service-discovery:$version"

        const val webDependencies = "io.vertx:vertx-web:$version"

        const val webClientDependencies = "io.vertx:vertx-web-client:$version"

        const val mongodbDepdendencies = "io.vertx:vertx-mongo-client:$version"

        val coreTestDependencies: List<String> = listOf(
            "io.vertx:vertx-junit5:$version"
        )
    }

    object Koin {
        const val version = "2.2.0-rc-4"

        const val coreDependencies = "org.koin:koin-core:$version"
        const val testDependencies = "org.koin:koin-test:$version"
    }

    object Logger {
        const val log4j = "2.14.0"
        const val kotlinLogging = "2.0.3"
    }

    object Testing {
        const val junit = "5.7.0"
        const val aspectJ = "3.18.1"
    }
}