plugins {
    id 'java'
    id 'org.springframework.boot' version '3.1.2'
    id 'io.spring.dependency-management' version '1.1.2'
}

group = 'example'
version = '0.0.1-SNAPSHOT'

java {
    sourceCompatibility = '17'
    targetCompatibility = '17'
}

repositories {
    mavenCentral()
}

dependencies {
    implementation 'org.springframework.boot:spring-boot-starter-web'
    testImplementation 'org.springframework.boot:spring-boot-starter-test'

    implementation 'org.springframework.data:spring-data-jdbc'
    testImplementation 'com.h2database:h2'

    implementation 'org.springframework.boot:spring-boot-starter-security'

    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}