allprojects {
    repositories {
        mavenCentral()
        maven(url = "http://maven.fabricmc.net"){
            name = "Fabric"
        }
        maven(url = "https://libraries.minecraft.net/"){
            name = "Mojang"
        }
        jcenter()
    }
}