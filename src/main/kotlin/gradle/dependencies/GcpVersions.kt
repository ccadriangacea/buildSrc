package gradle.dependencies

object GcpVersions {
    private const val bomVersion = "16.1.0"
    const val bomDependencies = "com.google.cloud:libraries-bom:$bomVersion"

    object Auth {
        private const val gaxVersion = "1.60.1"
        const val version = "0.22.0"

        val dependencies: ProjectDependencies = linkedSetOf(
            "com.google.api:gax:$gaxVersion",
            "com.google.auth:google-auth-library-oauth2-http:$version"
        )
    }

    object PubSub {
        const val version = "1.109.0"

        val coreDependencies: ProjectDependencies = linkedSetOf(
            "com.google.cloud:google-cloud-pubsub:$version"
        )
    }

    object Tasks {
        const val version = "1.30.8"

        val coreDependencies: ProjectDependencies = linkedSetOf(
            "com.google.cloud:google-cloud-tasks:$version"
        )
    }

    object Firebase {
        object Admin {
            const val version = "7.0.1"
            val coreDependencies: ProjectDependencies = linkedSetOf(
                "com.google.firebase:firebase-admin:$version"
            )
        }
    }
}