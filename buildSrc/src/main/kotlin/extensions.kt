import org.gradle.api.Project
import org.gradle.kotlin.dsl.provideDelegate

fun Project.hasProp(name: String): Boolean = name in project.properties

fun Project.prop(name: String): String? = project.properties[name] as? String
