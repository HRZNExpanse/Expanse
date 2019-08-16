plugins {
    `java-library`
}

val downloadSchemaCompiler by tasks.registering(Exec::class) {
    val spatial_version: String by project

    downloadSpatial("tools", "schema_compiler-x86_64-${osNativesName()}", spatial_version)

    inputs.property("spatial_version", spatial_version)
    outputs.file("build/libs/schema_compiler")
}

val downloadSpatialSchema by tasks.registering(Exec::class) {
    val spatial_version: String by project
    val output = file("build/libs/improbable")
    if (output.exists()) output.delete()
    downloadSpatial("schema", "standard_library", spatial_version)

    inputs.property("spatial_version", spatial_version)
    outputs.dir(output)
}

val compileSchema by tasks.registering(Exec::class) {
    dependsOn(downloadSchemaCompiler)
    dependsOn(downloadSpatialSchema)
    // TODO: incremental build (see https://docs.improbable.io/reference/14.0/shared/schema/introduction#caching-previously-generated-code)
    commandLine(
            "build/libs/schema_compiler",
            "--schema_path=./build/libs/",
            "--schema_path=./src/main/schema/",
            "--load_all_schema_on_schema_path",
            "--java_out=./build/schema",
            "--descriptor_set_out=./build/descriptor",
            "--dependency_out=./build/deps.txt"
    )

    inputs.dir("src/main/schema")
    outputs.dir("build/schema")
    outputs.file("build/descriptor")
}

tasks.named("compileJava").configure {
    dependsOn(compileSchema)
}

sourceSets.main {
    java {
        setSrcDirs(listOf("build/schema"))
    }
}

dependencies {
    api(project(":spatial_stl"))
}
