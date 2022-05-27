plugins {
    kotlin("jvm") version "1.6.21"
    id("org.moditect.gradleplugin") version "1.0.0-rc3"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))
}

tasks.addMainModuleInfo {
    version = project.version
    jvmVersion.set("9")
    overwriteExistingFiles.set(true)
    module {
        moduleInfoFile = File("$projectDir/src/main/java-9/module-info.java")
    }
}

/* TODO: Uncomment this to make the build succeed
project.afterEvaluate {
    val compileJavaTask = tasks.compileJava.get()
    compileJavaTask.setDependsOn(compileJavaTask.dependsOn - tasks.addDependenciesModuleInfo.get())
}
*/
