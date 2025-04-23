plugins {
    kotlin("jvm") version "1.9.22"
    application
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib")

    // Vulnérables volontairement
    implementation("org.apache.logging.log4j:log4j-core:2.14.1") // CVE-2021-44228 (Log4Shell)
    implementation("com.fasterxml.jackson.core:jackson-databind:2.9.9") // CVE-2019-12384
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions.jvmTarget = "17"
}

tasks.withType<JavaCompile> {
    sourceCompatibility = "17"
    targetCompatibility = "17"
}

application {
    mainClass.set("MainKt")
}

dependencyLocking {
    lockAllConfigurations()
}
