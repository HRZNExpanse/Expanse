allprojects {
    repositories {
        mavenCentral()
        maven(url = "http://maven.fabricmc.net"){
            name = "Fabric"
        }
        jcenter()
    }
}