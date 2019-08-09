import org.jetbrains.kotlin.gradle.plugin.KotlinPlatformJvmPlugin

plugins {
    `java-library`
    kotlin("jvm") apply false
}

subprojects {
    apply<JavaLibraryPlugin>()
    apply<KotlinPlatformJvmPlugin>()

    dependencies {
        api("com.google.code.findbugs:jsr305:3.0.2")

        if (this@subprojects.name != "base") implementation(project(":worker:base"))
        implementation(project(":schema"))

        implementation("org.apache.logging.log4j:log4j-core:${prop("log4j_version")}")
        implementation("org.apache.commons:commons-lang3:${prop("commons-lang_version")}")
    }
}
