plugins {
    id("org.springframework.boot") version "3.1.0"
    id("io.spring.dependency-management") version "1.1.3"
    kotlin("jvm") version "1.8.0"
}

group = "com.example"
version = "1.0.0"
java.sourceCompatibility = JavaVersion.VERSION_17 // Adjust Java version if needed

repositories {
    mavenCentral()
}

dependencies {
    // Spring Boot Actuator for monitoring
    implementation("org.springframework.boot:spring-boot-starter-actuator")

    // Micrometer Prometheus registry
    implementation("io.micrometer:micrometer-registry-prometheus")

    // Logstash Encoder for ELK logging
    implementation("net.logstash.logback:logstash-logback-encoder:7.3")
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}
