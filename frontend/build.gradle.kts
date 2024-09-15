import com.github.gradle.node.npm.task.NpmTask

plugins {
    id("com.github.node-gradle.node") version "7.0.2"
}

node {
    version = "22.12.2"
    npmVersion = "10.8.1"
    download = true
}

tasks.register<NpmTask>("runBuild") {
    args = listOf("run", "build")
    workingDir = file(".")
}

tasks.register<Copy>("copyWebApp") {
    from("dist")
    into("../backend/src/main/resources/static")
    dependsOn("runBuild")
}


