package gradle.dependencies

object Versions {
    const val kotlin = "1.4.21"
    const val kotlinCoroutines = "1.4.2"
    const val kotlinApi = "1.4"
    const val jvmTargetVersion = "15"

    object Vertx {
        const val version = "4.0.0"
        const val nettyVersion = "4.1.54.Final"

        val vertxCoreDependencies: List<String> = listOf(
            "io.vertx:vertx-core:$version",
            "io.vertx:vertx-lang-kotlin:$version",
            "io.vertx:vertx-lang-kotlin-coroutines:$version"
        )

        val vertxCoreTestDependencies: List<String> = listOf(
            "io.vertx:vertx-junit5:$version"
        )
    }

    object Testing {
        const val junit = "5.7.0"
        const val aspectJ = "3.18.1"
    }
}