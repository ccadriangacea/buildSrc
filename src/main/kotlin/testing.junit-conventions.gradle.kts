import gradle.dependencies.CoreVersions.Testing
import gradle.dependencies.import

configurations.all {
    exclude(group = "junit", module = "junit")
    exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
}

dependencies {
    Testing.junitDependencies.import("api", this)
    Testing.junitRuntimeDependencies.import("testRuntimeOnly", this)
}

tasks {
    withType(Test::class) {
        useJUnitPlatform()
        exclude("**/Native*")
    }
}
