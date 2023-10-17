plugins {
    id("java")


}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation ("io.rest-assured:rest-assured:4.3.3")
    testImplementation ("io.cucumber:cucumber-java:6.10.4")
    testImplementation ("io.cucumber:cucumber-junit:6.10.4")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.15.2")



}

tasks.test {
    useJUnitPlatform()
}
