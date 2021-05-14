package gradle.dependencies

object CoreVersions {
    const val kotlinApi = "1.4"
    const val jvmTargetVersion = "11"

    object Kotlin {
        const val kotlinVersion = "1.4.32"
        private const val kotlinCoroutinesVersion = "1.4.3"

        const val kotlinBom = "org.jetbrains.kotlin:kotlin-bom:$kotlinVersion"
        const val kotlinCoroutinesBom = "org.jetbrains.kotlinx:kotlinx-coroutines-bom:$kotlinCoroutinesVersion"

        val reflect: ProjectDependencies = linkedSetOf(
            "org.jetbrains.kotlin:kotlin-reflect:$kotlinVersion"
        )
    }

    object Vertx {
        const val vertxVersion = "4.0.2"
        const val nettyVersion = "4.1.59.Final"
        const val jsonVersion = "2.12.1"
        private val hazelcastKubernetesVersion = "2.2.1"
        private val igniteVersion = "2.9.1"

        val coreDependencies: ProjectDependencies = linkedSetOf(
            "io.vertx:vertx-core:$vertxVersion",
            "io.vertx:vertx-lang-kotlin:$vertxVersion",
            "io.vertx:vertx-lang-kotlin-coroutines:$vertxVersion"
        )

        val configDependencies: ProjectDependencies = linkedSetOf(
            "io.vertx:vertx-config:$vertxVersion",
            "com.fasterxml.jackson.module:jackson-module-kotlin:$jsonVersion",
            "com.fasterxml.jackson.module:jackson-module-paranamer:$jsonVersion",
            "com.fasterxml.jackson.datatype:jackson-datatype-jsr310:$jsonVersion"
        )

        val codegenDependencies: ProjectDependencies = linkedSetOf(
            "io.vertx:vertx-codegen:$vertxVersion"
        )
        val codegenKaptDependencies: ProjectDependencies = linkedSetOf(
            "io.vertx:vertx-codegen:$vertxVersion"
        )

        val jwtDependencies: ProjectDependencies = linkedSetOf(
            "io.vertx:vertx-auth-common:$vertxVersion",
            "io.vertx:vertx-auth-jwt:$vertxVersion"
        )

        val mongodbDependencies: ProjectDependencies = linkedSetOf(
            "io.vertx:vertx-mongo-client:$vertxVersion"
        )

        val oauth2Dependencies: ProjectDependencies = linkedSetOf(
            "io.vertx:vertx-auth-common:$vertxVersion",
            "io.vertx:vertx-auth-oauth2:$vertxVersion"
        )

        val serviceDiscoveryDependencies: ProjectDependencies = linkedSetOf(
            "io.vertx:vertx-service-discovery:$vertxVersion"
        )

        val webDependencies: ProjectDependencies = linkedSetOf(
            "io.vertx:vertx-web:$vertxVersion"
        )

        val webClientDependencies: ProjectDependencies = linkedSetOf(
            "io.vertx:vertx-web-client:$vertxVersion"
        )

        val hazelcastDependencies: ProjectDependencies = linkedSetOf(
            "io.vertx:vertx-hazelcast:$vertxVersion",
            "com.hazelcast:hazelcast-kubernetes:$hazelcastKubernetesVersion"
        )

        val igniteDependencies: ProjectDependencies = linkedSetOf(
            "io.vertx:vertx-ignite:$vertxVersion",
            "org.apache.ignite:ignite-slf4j:$igniteVersion"
        )

        val zookeeperDependencies: ProjectDependencies = linkedSetOf(
            "io.vertx:vertx-zookeeper:$vertxVersion"
        )

        val coreTestDependencies: ProjectDependencies = linkedSetOf(
            "io.vertx:vertx-junit5:$vertxVersion"
        )
    }

    object Koin {
        const val version = "2.2.1"

        val coreDependencies: ProjectDependencies = linkedSetOf("org.koin:koin-core:$version")
        val testDependencies: ProjectDependencies = linkedSetOf("org.koin:koin-test:$version")
    }

    object Logger {
        private const val slf4jVersion = "1.7.30"
        private const val log4jVersion = "2.14.0"
        private const val kotlinLogging = "2.0.4"

        val kotlinLoggingDependencies: ProjectDependencies = linkedSetOf(
            "io.github.microutils:kotlin-logging-jvm:$kotlinLogging",
            "org.slf4j:slf4j-api:$slf4jVersion",
            "org.apache.logging.log4j:log4j-slf4j-impl:$log4jVersion"
        )
    }

    object Quarkus {
        const val quarkusVersion = "1.11.3.Final"
        const val quarkusBom = "io.quarkus:quarkus-bom:$quarkusVersion"

        val quarkusDependencies = linkedSetOf(
            "io.quarkus:quarkus-arc",
            "io.quarkus:quarkus-kotlin",
            "io.quarkus:quarkus-resteasy",
            "io.quarkus:quarkus-resteasy-jackson",
            "io.quarkus:quarkus-vertx"
        )

        val quarkusTestDependencies = linkedSetOf(
            "io.quarkus:quarkus-junit5",
            "io.rest-assured:rest-assured"
        )
    }

    object Testing {
        const val junitVersion = "5.7.0"
        const val aspectJVersion = "3.19.0"

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
