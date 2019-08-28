plugins {
    `java-library`
}

dependencies {
    api(project(":spatial_stl"))
    implementation("info.picocli:picocli:3.8.2")
}
