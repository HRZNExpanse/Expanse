plugins {
    `java-library`
}

val downloadSpatialSDK by tasks.registering(Exec::class) {
    val spatial_version: String by project

    downloadSpatial("worker_sdk", "java", spatial_version)
//    downloadSpatial("worker_sdk", "java_native-dynamic-x86_64-${osNativesName()}", spatial_version)
    inputs.property("spatial_version", spatial_version)
    outputs.file("build/libs/improbable-worker.jar")
}

dependencies {
    api(files("build/libs/improbable-worker.jar") {
        builtBy(downloadSpatialSDK)
    })
//    api(files("build/libs/improbable-worker-native-${osNativesName()}-x64.jar"))
}
