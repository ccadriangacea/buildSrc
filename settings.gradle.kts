import org.gradle.util.GUtil.loadProperties

logger.lifecycle("\n>>> Running settings.gradle.kts in buildSrc\n")

rootProject.name = "buildSrc"

bootstrapProperties()

pluginManagement {
    repositories {
        gradlePluginPortal()
    }

    // Used to overwrite the version for kotlin-dsl present in gradle
    resolutionStrategy {
        val kotlinDslVersion: String by System.getProperties()
        eachPlugin {
            logger.lifecycle(" > Checking if plugin version must be adjusted for: ${this@eachPlugin.requested.id.id}")
            when (this@eachPlugin.requested.id.id) {
                "org.gradle.kotlin.kotlin-dsl" -> if (kotlinDslVersion.isNotEmpty()) {
                    useVersion(kotlinDslVersion)
                        .also { logger.lifecycle("   < Loading plugin: ${this@eachPlugin.requested.id} with version $kotlinDslVersion...") }
                }
            }
        }
    }
}

/*
 * This makes the gradle.properties file available to buildSrc
 */
fun bootstrapProperties() {
    val useCurrentProject: String by System.getProperties()
    val rootProjectPath = if (useCurrentProject == "true") rootDir.absolutePath else rootDir.parentFile.absolutePath
    val gradlePropertiesFilePath = rootProjectPath.plus("/gradle.properties")
    logger.lifecycle("  > bootstrapping gradle.properties from: $gradlePropertiesFilePath")

    loadProperties(file(gradlePropertiesFilePath))
        .apply {
            filter { it.key.toString().startsWith("systemProp.") }
                .forEach {
                    logger.debug("    + adding property: $it")
                    it.key.toString().replace("systemProp.", "")
                        .apply { System.setProperty(this, it.value.toString()) }
                }
        }
    logger.lifecycle("  < done loading properties from gradle.properties...")
    logger.lifecycle("  > System properties listed only on level info")
        .also {
            System.getProperties()
                .map { Pair(it.key.toString(), it.value.toString()) }
                .sortedBy { it.first }
                .also { pairs: List<Pair<String, String>> ->
                    val longestKey = pairs.map { it.first.length }.max() ?: 0
                    pairs
                        .forEach { logger.info("    - ${it.first.padEnd(longestKey)} -> ${it.second}") }
                }
        }
}