package gradle.dependencies

import org.gradle.kotlin.dsl.DependencyHandlerScope

@SinceKotlin("1.1")
public typealias ProjectDependencies = java.util.LinkedHashSet<String>

fun ProjectDependencies.import(configuration: String, dependencyHandlerScope: DependencyHandlerScope) =
    this.forEach { projectDependency -> dependencyHandlerScope { configuration(projectDependency) } }