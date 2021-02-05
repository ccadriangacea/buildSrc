import gradle.dependencies.CoreVersions.Vertx
import gradle.dependencies.import

plugins {
    id("common.kotlin-conventions")
}

// This makes sure the version of the dependencies are the ones configured in gradle.properties
configurations.all {
    resolutionStrategy {
        eachDependency {
            when (this@eachDependency.requested.group) {
                "io.vertx" -> {
                    useTarget(mapOf("group" to requested.group, "name" to requested.name, "version" to Vertx.version))
                    because("Vertx version ${Vertx.version} is latest")
                    logVersionAdjustment(this@eachDependency.requested.toString(), Vertx.version)
                }
                "io.netty" -> {
                    useTarget(mapOf("group" to requested.group, "name" to requested.name, "version" to Vertx.nettyVersion))
                    because("Netty version ${Vertx.nettyVersion} is latest")
                    logVersionAdjustment(this@eachDependency.requested.toString(), Vertx.nettyVersion)
                }
            }
        }
    }
}

fun logVersionAdjustment(adjustingFor: String, adjustingTo: String) {
    logger.info(" > Adjusting dependency version for[$adjustingFor] to $adjustingTo")
}

dependencies {
    Vertx.coreDependencies.import("api", this)

    Vertx.codegenDependencies.import("api", this)

    Vertx.coreTestDependencies.import("testImplementation", this)
}