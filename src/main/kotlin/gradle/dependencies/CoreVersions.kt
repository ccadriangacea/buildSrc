package gradle.dependencies

object CoreVersions {
    const val kotlinApi = "1.4"
    const val jvmTargetVersion = "11"

    object Kotlin {
        const val kotlinVersion = "1.4.21"
        private const val kotlinCoroutinesVersion = "1.4.2"

        const val kotlinBom = "org.jetbrains.kotlin:kotlin-bom:$kotlinVersion"
        const val kotlinCoroutinesBom = "org.jetbrains.kotlinx:kotlinx-coroutines-bom:$kotlinCoroutinesVersion"

        val reflect: ProjectDependencies = linkedSetOf(
            "org.jetbrains.kotlin:kotlin-reflect:$kotlinVersion"
        )
    }

    object Vertx {
        const val version = "4.0.0"
        const val nettyVersion = "4.1.54.Final"
        const val jsonVersion = "2.12.0-rc2"

        val coreDependencies: ProjectDependencies = linkedSetOf(
            "io.vertx:vertx-core:$version",
            "io.vertx:vertx-lang-kotlin:$version",
            "io.vertx:vertx-lang-kotlin-coroutines:$version"
        )

        val configDependencies: ProjectDependencies = linkedSetOf(
            "io.vertx:vertx-config:$version",
            "com.fasterxml.jackson.module:jackson-module-kotlin:$jsonVersion",
            "com.fasterxml.jackson.module:jackson-module-paranamer:$jsonVersion"
        )

        val codegenDependencies: ProjectDependencies = linkedSetOf(
            "io.vertx:vertx-codegen:$version"
        )
        val codegenKaptDependencies: ProjectDependencies = linkedSetOf(
            "io.vertx:vertx-codegen:$version"
        )

        val jwtDependencies: ProjectDependencies = linkedSetOf(
            "io.vertx:vertx-auth-common:$version",
            "io.vertx:vertx-auth-jwt:$version"
        )

        val mongodbDependencies: ProjectDependencies = linkedSetOf(
            "io.vertx:vertx-mongo-client:$version"
        )

        val oauth2Dependencies: ProjectDependencies = linkedSetOf(
            "io.vertx:vertx-auth-common:$version",
            "io.vertx:vertx-auth-oauth2:$version"
        )

        val serviceDiscoveryDependencies: ProjectDependencies = linkedSetOf(
            "io.vertx:vertx-service-discovery:$version"
        )

        val webDependencies: ProjectDependencies = linkedSetOf(
            "io.vertx:vertx-web:$version"
        )

        val webClientDependencies: ProjectDependencies = linkedSetOf(
            "io.vertx:vertx-web-client:$version"
        )

        val coreTestDependencies: ProjectDependencies = linkedSetOf(
            "io.vertx:vertx-junit5:$version"
        )
    }

    object Koin {
        const val version = "2.2.0-rc-4"

        val coreDependencies: ProjectDependencies = linkedSetOf("org.koin:koin-core:$version")
        val testDependencies: ProjectDependencies = linkedSetOf("org.koin:koin-test:$version")
    }

    object Logger {
        const val log4j = "2.14.0"
        const val kotlinLogging = "2.0.3"
    }

    object Testing {
        const val junitVersion = "5.7.0"
        const val aspectJVersion = "3.18.1"

        val junitDependencies: ProjectDependencies = linkedSetOf(
            "org.junit.jupiter:junit-jupiter-api:$junitVersion",
            "org.junit.jupiter:junit-jupiter-params:$junitVersion",
            "org.assertj:assertj-core:$aspectJVersion"
        )
        val junitRuntimeDependencies: ProjectDependencies = linkedSetOf(
            "org.junit.jupiter:junit-jupiter-engine:$junitVersion"
        )
    }
}