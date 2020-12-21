import gradle.dependencies.Versions
import gradle.kotlin.dsl.accessors._39138eb6e76d56a7e920b4b84b56bbb7.test
import org.gradle.api.tasks.testing.Test
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.invoke
import org.gradle.kotlin.dsl.withType

dependencies {
    // Junit
    "testImplementation"("org.junit.jupiter:junit-jupiter-api:${Versions.Testing.junit}")
    "testImplementation"("org.junit.jupiter:junit-jupiter-params:${Versions.Testing.junit}")
    "testRuntimeOnly"("org.junit.jupiter:junit-jupiter-engine:${Versions.Testing.junit}")

    // AspectJ
    "testImplementation"("org.assertj:assertj-core:${Versions.Testing.aspectJ}")
}

tasks {
    withType(Test::class) {
        useJUnitPlatform()
        exclude("**/Native*")
    }

    test {
        useJUnitPlatform()
    }
}