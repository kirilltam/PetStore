import org.codehaus.groovy.tools.shell.util.Logger.io
import java.util.regex.Pattern.compile

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
    implementation("io.github.bonigarcia:webdrivermanager:5.5.3")
    testImplementation ("com.codeborne:selenide:6.17.0")
    implementation("net.masterthought:cucumber-reporting:5.7.7")
    testImplementation("org.testng:testng:7.1.0")
    testImplementation("org.testng:testng:7.1.0")

    compile ("com.epam.reportportal:agent-java-cucumber6:5.0.5")


}


tasks.test {
    useJUnitPlatform()
}

