package gradle.dependencies

object LibrariesVersions {
    object Camel {
        const val camelVersion = "3.7.1"

        val coreDependencies: ProjectDependencies = linkedSetOf(
            "org.apache.camel:camel-core:$camelVersion",
            "org.apache.camel:camel-stream:$camelVersion"
        )

        val supportDependencies: ProjectDependencies = linkedSetOf(
            "org.apache.camel:camel-support:$camelVersion"
        )

        val natsDependencies: ProjectDependencies = linkedSetOf(
            "org.apache.camel:camel-nats:$camelVersion"
        )

        val nettyDependencies: ProjectDependencies = linkedSetOf(
            "org.apache.camel:camel-netty-http:$camelVersion"
        )

        val vertxDependencies: ProjectDependencies = linkedSetOf(
            "org.apache.camel:camel-vertx:$camelVersion"
        )
    }

    object Nats {
        const val version = "2.8.0"

        const val conscryptOpenjdkVersion = "2.5.1"
        val coreDependencies: ProjectDependencies = linkedSetOf(
            "org.conscrypt:conscrypt-openjdk-uber:$conscryptOpenjdkVersion",
            "io.nats:jnats:$version"
        )
    }
}
