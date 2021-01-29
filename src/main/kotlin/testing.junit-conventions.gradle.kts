import gradle.dependencies.CoreVersions.Testing
import gradle.dependencies.import

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
