import gradle.dependencies.Versions

dependencies {
    // Junit
    "api"("org.junit.jupiter:junit-jupiter-api:${Versions.Testing.junit}")
    "api"("org.junit.jupiter:junit-jupiter-params:${Versions.Testing.junit}")
    "testRuntimeOnly"("org.junit.jupiter:junit-jupiter-engine:${Versions.Testing.junit}")

    // AspectJ
    "api"("org.assertj:assertj-core:${Versions.Testing.aspectJ}")
}

tasks {
    withType(Test::class) {
        useJUnitPlatform()
        exclude("**/Native*")
    }
}