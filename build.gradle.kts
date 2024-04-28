version = "1.0-SNAPSHOT"


plugins {
    id("java")
    id("io.qameta.allure") version "2.11.2"
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("com.codeborne:selenide-appium:7.2.0")
    testImplementation("io.appium:java-client:9.1.0")
    testImplementation("org.aeonbits.owner:owner:1.0.4")

    testImplementation("org.slf4j:slf4j-api:2.0.12")
    testImplementation("org.apache.logging.log4j:log4j-slf4j2-impl:2.23.1")
    testImplementation("org.apache.logging.log4j:log4j-api:2.23.1")
    testImplementation("org.apache.logging.log4j:log4j-core:2.23.1")

    testCompileOnly("org.projectlombok:lombok:1.18.30")
    testAnnotationProcessor("org.projectlombok:lombok:1.18.30")

    testImplementation(platform("org.junit:junit-bom:5.10.2"))
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.2")
    testImplementation("org.junit.platform:junit-platform-console-standalone:1.10.2")

    testImplementation("org.assertj:assertj-core:3.25.2")

    testImplementation("io.qameta.allure:allure-junit5:2.25.0")
    testImplementation("io.qameta.allure:allure-selenide:2.25.0")

}

tasks.register<Copy>("getDeps") {
    from(sourceSets["test"].runtimeClasspath)
    into("build/libs/dependency-jars")
}

tasks.register<Jar>("packageTests") {
    dependsOn("getDeps")
    from(sourceSets["test"].output)
    archiveFileName.set("${rootProject.name}-tests.jar")
}

tasks.register<Zip>("zip") {
    dependsOn("packageTests")
    from("build/libs/")
    include("*")
    include("*/*")
    exclude("${rootProject.name}.zip")
    archiveFileName.set("${rootProject.name}.zip")
    destinationDirectory.set(file("build/libs/"))
}

tasks.test {
    useJUnitPlatform()
}

