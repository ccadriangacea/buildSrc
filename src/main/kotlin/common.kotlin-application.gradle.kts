plugins {
    java
    idea

    id("common.kotlin-conventions")

    id("com.github.ben-manes.versions")
    id("com.github.johnrengelman.shadow")
}

tasks {
    findByName("clean")
        .apply { this?.doLast { delete(project.projectDir.toPath().resolve("out").toFile().absolutePath) } }
}
