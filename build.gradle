/*plugins {
    id 'java'
}*/

apply plugin: 'java'
apply plugin: 'com.google.protobuf'
apply plugin: 'idea'


group 'com.az'
version '1.0-SNAPSHOT'

sourceCompatibility = 1.8


buildscript {
    repositories {
        mavenCentral()
    }
    dependencies {
        classpath 'com.google.protobuf:protobuf-gradle-plugin:0.8.8'
    }
}

repositories {
    mavenCentral()
}

dependencies {
    // gRPC..
    compile 'io.grpc:grpc-netty-shaded:1.21.0'
    compile 'io.grpc:grpc-protobuf:1.21.0'
    compile 'io.grpc:grpc-stub:1.21.0'
    // Junit
    testCompile group: 'junit', name: 'junit', version: '4.12'
}

protobuf {
    protoc {
        artifact = "com.google.protobuf:protoc:3.7.1"
    }
    plugins {
        grpc {
            artifact = 'io.grpc:protoc-gen-grpc-java:1.21.0'
        }
    }
    generateProtoTasks {
        all()*.plugins {
            grpc {}
        }
    }
}