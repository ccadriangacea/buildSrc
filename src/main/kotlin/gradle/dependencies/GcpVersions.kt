package gradle.dependencies

object GcpVersions {
    private const val bomVersion = "16.4.0"
    const val bomDependencies = "com.google.cloud:libraries-bom:$bomVersion"

    object Auth {
        private const val gaxVersion = "1.60.1"
        const val version = "0.23.0"

        val dependencies: ProjectDependencies = linkedSetOf(
            "com.google.api:gax:$gaxVersion",
            "com.google.auth:google-auth-library-oauth2-http:$version"
        )
    }

    object PubSub {
        const val version = "1.111.0"

        val coreDependencies: ProjectDependencies = linkedSetOf(
            "com.google.cloud:google-cloud-pubsub:$version"
        )
    }

    object Tasks {
        const val version = "1.30.12"

        val coreDependencies: ProjectDependencies = linkedSetOf(
            "com.google.cloud:google-cloud-tasks:$version"
        )
    }

    object Firebase {
        object Admin {
            const val version = "7.1.0"
            val coreDependencies: ProjectDependencies = linkedSetOf(
                "com.google.firebase:firebase-admin:$version"
            )
        }
    }
}