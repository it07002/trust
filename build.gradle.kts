plugins {
    id("java")
    id("io.quarkus") version "3.5.0"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // Quarkus BOM
    implementation(enforcedPlatform("io.quarkus:quarkus-bom:3.5.0"))

    // Quarkus dependencies
    implementation("io.quarkus:quarkus-resteasy")          // REST endpoints
    implementation("io.quarkus:quarkus-resteasy-jackson")  // JSON support
    implementation("io.quarkus:quarkus-arc")               // CDI / dependency injection
    implementation("io.quarkus:quarkus-amazon-lambda-http") // AWS Lambda HTTP integration

    // AWS SDK v2 - DynamoDB
    implementation(platform("software.amazon.awssdk:bom:2.21.29"))
    implementation("software.amazon.awssdk:dynamodb-enhanced")
    implementation("software.amazon.awssdk:dynamodb")

    // Lombok
    compileOnly("org.projectlombok:lombok:1.18.32")
    annotationProcessor("org.projectlombok:lombok:1.18.32")

    // Testing
    testImplementation("io.quarkus:quarkus-junit5")
    testImplementation("io.rest-assured:rest-assured")
}

tasks.test {
    useJUnitPlatform()
}

tasks.register<Zip>("packageLambda") {
    group = "build"
    description = "Builds Quarkus and packages for AWS Lambda"
    dependsOn("build")
    from("build/quarkus-app") {
        into("/")
    }
    archiveFileName.set("lambda-function.zip")
    destinationDirectory.set(file("${projectDir}"))
}