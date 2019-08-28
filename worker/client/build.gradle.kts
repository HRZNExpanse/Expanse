plugins {
    id("fabric-loom") version "0.2.5-SNAPSHOT"
}

dependencies {
    minecraft(group = "com.mojang", name = "minecraft", version = "1.14.4")
    mappings(group = "net.fabricmc", name = "yarn", version =  "1.14.4+build.12")

    modImplementation(group = "net.fabricmc", name = "fabric-loader", version = "0.5.0+build.162")
    
    implementation(project(":worker:base"))
}
