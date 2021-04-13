import gradle.dependencies.CoreVersions.Vertx
import gradle.dependencies.import
import gradle.util.logVersionAdjustment

plugins {
    id("common.kotlin-conventions") // Just conventions as this can be an app or a library
}

configurations.all {
    resolutionStrategy {
        eachDependency {
            with(this@eachDependency.requested.group.toString()) {
                when {
                    this@with == "io.vertx" -> {
                        if (this@eachDependency.requested.version.toString() != Vertx.vertxVersion) {
                            useTarget(mapOf("group" to requested.group, "name" to requested.name, "version" to Vertx.vertxVersion))
                            because("Vertx version ${Vertx.vertxVersion} is latest; lets sync all to this")
                            logVersionAdjustment(logger, this@eachDependency.requested.toString(), Vertx.vertxVersion)
                        }
                    }
                    this@with.startsWith("io.netty") -> {
                        if (this@eachDependency.requested.version.toString() != Vertx.nettyVersion) {
                            useTarget(mapOf("group" to requested.group, "name" to requested.name, "version" to Vertx.nettyVersion))
                            because("Netty version ${Vertx.nettyVersion} is latest; lets sync all to this")
                            logVersionAdjustment(logger, this@eachDependency.requested.toString(), Vertx.nettyVersion)
                        }
                    }
                    this@with.startsWith("com.fasterxml.jackson") -> {
                        if (this@eachDependency.requested.version.toString() != Vertx.jsonVersion) {
                            useTarget(mapOf("group" to requested.group, "name" to requested.name, "version" to Vertx.jsonVersion))
                            because("Jackson version ${Vertx.jsonVersion} is latest; lets sync all to this")
                            logVersionAdjustment(logger, this@eachDependency.requested.toString(), Vertx.jsonVersion)
                        }
                    }
                }
            }
        }
    }
}

dependencies {
    Vertx.coreDependencies.import("api", this)

//    Vertx.codegenDependencies.import("api", this)

    Vertx.coreTestDependencies.import("testImplementation", this)
}