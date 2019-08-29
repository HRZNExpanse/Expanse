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
        implementation(project(":minecraft"))
        implementation("net.fabricmc:sponge-mixin:0.7.11.38")
        implementation("org.apache.logging.log4j:log4j-core:${prop("log4j_version")}")
        implementation("org.apache.commons:commons-lang3:${prop("commons-lang_version")}")
        implementation("org.reflections:reflections:0.9.11")
        implementation("com.electronwill.night-config:core:3.6.0")
        implementation("com.electronwill.night-config:toml:3.6.0")
    }
}
