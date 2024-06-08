plugins {
    application
    id ("jacoco")
    id("java")
    id("checkstyle")
}

group = "hexlet.code"
version = "1.0-SNAPSHOT"

application { mainClass.set("hexlet.code.App") }

repositories {
    mavenCentral()
}

dependencies {
    implementation ("com.fasterxml.jackson.core:jackson-databind:2.13.3")
    implementation ("info.picocli:picocli:4.7.6")
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.jacocoTestReport { reports { xml.required.set(true) } }

tasks.test {
    useJUnitPlatform()
    finalizedBy(tasks.jacocoTestReport)
}