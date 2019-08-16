import org.apache.tools.ant.taskdefs.condition.Os
import org.gradle.api.Project
import org.gradle.api.tasks.Exec

fun Project.hasProp(name: String): Boolean = name in project.properties

fun Project.prop(name: String): String? = project.properties[name] as? String

fun Exec.downloadSpatial(pkgType: String, pkgName: String, version: String) {
    logger.info("Downloading Spatial $pkgType/$pkgName version $version")
    commandLine(
            "spatial",
            "package",
            "get",
            "--force",
            "--unzip",
            pkgType,
            pkgName,
            version,
            "build/libs/"
    )
}

fun osNativesName(): String {
    return when {
        Os.isFamily(Os.FAMILY_WINDOWS) -> "win32"
        Os.isFamily(Os.FAMILY_MAC) -> "macos"
        Os.isFamily(Os.FAMILY_UNIX) -> "linux"
        else -> throw UnsupportedOperationException("Unrecognized OS")
    }
}