package gradle.dependencies

object NatsVersions {
    const val version = "2.8.0"
    const val conscryptOpenjdkVersion = "2.5.1"

    val natsDependencies: List<String> = listOf(
        "org.conscrypt:conscrypt-openjdk-uber:$conscryptOpenjdkVersion",
        "io.nats:jnats:$version"
    )
}