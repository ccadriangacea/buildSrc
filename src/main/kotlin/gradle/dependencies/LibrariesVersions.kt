package gradle.dependencies

object LibrariesVersions {
    object Camel {
        const val camelVersion = "3.7.2"

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

    object Databases {
        private const val arangodbVersion = "6.12.1"
        private const val arangoJacksonVelocypackVersion = "2.0.0"

        val arangodbDependencies: ProjectDependencies = linkedSetOf(
            "com.arangodb:arangodb-java-driver:$arangodbVersion",
            "com.arangodb:jackson-dataformat-velocypack:$arangoJacksonVelocypackVersion"
        )
    }

    object Nats {
        const val version = "2.8.0"

        private const val conscryptOpenjdkVersion = "2.5.1"
        val coreDependencies: ProjectDependencies = linkedSetOf(
            "org.conscrypt:conscrypt-openjdk-uber:$conscryptOpenjdkVersion",
            "io.nats:jnats:$version"
        )
    }
}
