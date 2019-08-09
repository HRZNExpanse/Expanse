val downloadSpatialSDK by tasks.registering(Exec::class) {
    val spatial_version: String by project

    logger.info("Downloading Spatial version $spatial_version")
    commandLine(
            "spatial",
            "package",
            "get",
            "--force",
            "--unzip",
            "worker_sdk",
            "java",
            spatial_version,
            "libs/"
    )
    inputs.property("spatial_version", spatial_version)
    outputs.file("libs/improbable-worker.jar")
}

dependencies {
    api(files("libs/improbable-worker.jar") {
        builtBy(downloadSpatialSDK)
    })
    implementation("info.picocli:picocli:3.8.2")
}
