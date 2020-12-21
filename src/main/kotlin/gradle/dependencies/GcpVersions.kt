package gradle.dependencies

object GcpVersions {
    private const val bomVersion = "16.1.0"
    const val bomDependencies = "com.google.cloud:libraries-bom:$bomVersion"

    object Auth {
        private const val gaxVersion = "1.60.1"
        const val version = "0.22.0"

        val dependencies: List<String> = listOf(
            "com.google.api:gax:$gaxVersion",
            "com.google.auth:google-auth-library-oauth2-http:$version"
        )
    }

    object PubSub {
        const val version = "1.109.0"
        const val dependencies = "com.google.cloud:google-cloud-pubsub:$version"
    }

    object Tasks {
        const val version = "1.30.8"
        const val depdendencies = "com.google.cloud:google-cloud-tasks:$version"
    }

    object Firebase {
        object Admin {
            const val version = "7.0.1"
            const val depdendencies = "com.google.firebase:firebase-admin:$version"
        }
    }
}