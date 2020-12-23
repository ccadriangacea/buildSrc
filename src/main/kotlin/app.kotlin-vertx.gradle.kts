import gradle.dependencies.Versions

plugins {
    id("common.kotlin-conventions")
}

// This makes sure the version of the dependencies are the ones configured in gradle.properties
configurations.all {
    resolutionStrategy {
        eachDependency {
            when (this@eachDependency.requested.group) {
                "io.vertx" -> {
                    useTarget(mapOf("group" to requested.group, "name" to requested.name, "version" to Versions.Vertx.version))
                    because("Vertx version ${Versions.Vertx.version} is latest")
                    logVersionAdjustment(this@eachDependency.requested.toString(), Versions.Vertx.version)
                }
                "io.netty" -> {
                    useTarget(mapOf("group" to requested.group, "name" to requested.name, "version" to Versions.Vertx.nettyVersion))
                    because("Netty version ${Versions.Vertx.nettyVersion} is latest")
                    logVersionAdjustment(this@eachDependency.requested.toString(), Versions.Vertx.nettyVersion)
                }
            }
        }
    }
}

fun logVersionAdjustment(adjustingFor: String, adjustingTo: String) {
    logger.info(" > Adjusting dependency version for[$adjustingFor] to $adjustingTo")
}

dependencies {
    Versions.Vertx.coreDependencies.forEach { "api"(it) }

    "api"("io.vertx:vertx-codegen:${Versions.Vertx.version}")
    "kapt"("io.vertx:vertx-codegen:${Versions.Vertx.version}")

    "testImplementation"(Versions.Vertx.coreTestDependencies)
}