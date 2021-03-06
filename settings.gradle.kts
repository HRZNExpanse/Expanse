include("worker")
file("worker").listFiles()!!.asSequence()
        .filter(File::isDirectory)
        .filter { it.name != ".gradle" && it.name != "libs" && it.name != "build" }
        .forEach { include("worker:${it.name}") }
include("schema")
include("minecraft")
include("spatial_stl")

val kotlin_version: String by settings

pluginManagement {
    repositories {
        jcenter()
        maven(url = "https://maven.fabricmc.net/") {
            name = "Fabric"
        }
        gradlePluginPortal()
    }
    resolutionStrategy {
        eachPlugin {
            logger.debug("Requested: " + requested.id.id)
            when (requested.id.id) {
                "de.undercouch.download" -> useVersion("4.0.0")
                else -> when (requested.id.namespace) {
                    "org.jetbrains.kotlin" -> useVersion(kotlin_version)
                }
            }
            if (requested.id.id == "kotlin2js") {
                useModule("org.jetbrains.kotlin:kotlin-gradle-plugin:${requested.version}")
            }
        }
    }
}