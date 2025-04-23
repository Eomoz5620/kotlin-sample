tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions.jvmTarget = "17" // Choisir la bonne version de la JVM (1.8, 11, 17, etc.)
}

tasks.withType<JavaCompile> {
    targetCompatibility = "17"  // Java cible Java 17
    sourceCompatibility = "17"
}

plugins {
    kotlin("jvm") version "1.9.22"
    application
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib")
    // dépendances vulnérables pour le test CVE
    implementation("org.apache.logging.log4j:log4j-core:2.14.1")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.9.9")
}

application {
    mainClass.set("MainKt")
}
