package gradle.util

import org.gradle.api.Project
import org.gradle.api.logging.Logger
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.project

fun Project.loadLocalProjects(configuration: String = "api", projectNames: List<String>) {
    dependencies {
        projectNames.stream().forEach { configuration(project(it)) }
    }
}

fun logVersionAdjustment(logger: Logger, adjustingFor: String, adjustingTo: String) {
    logger.info(" > Adjusting dependency version for[$adjustingFor] to $adjustingTo")
}