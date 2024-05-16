import com.vanniktech.maven.publish.JavadocJar
import com.vanniktech.maven.publish.KotlinMultiplatform
import com.vanniktech.maven.publish.SonatypeHost

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    //alias(libs.plugins.androidLibrary)
    id("module.publication")
    id("com.vanniktech.maven.publish") version "0.28.0"
}

kotlin {
    targetHierarchy.default()
    jvm()
    /*androidTarget {
        publishLibraryVariants("release")
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }*/
    //iosX64()
    //iosArm64()
    //iosSimulatorArm64()
    //linuxX64()

    sourceSets {
        val commonMain by getting {
            dependencies {
                //put your multiplatform dependencies here
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(libs.kotlin.test)
            }
        }
    }
}

/*
android {
    namespace = "io.github.vinner-it"
    compileSdk = libs.versions.android.compileSdk.get().toInt()
    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
    }
}
*/

mavenPublishing {
    coordinates(
        groupId = "io.github.vinner-it",
        artifactId = "vinner-it-kotlin",
        version = "1.0.0"
    )
    configure(
        KotlinMultiplatform(
            // configures the -javadoc artifact, possible values:
            // - `JavadocJar.None()` don't publish this artifact
            // - `JavadocJar.Empty()` publish an emprt jar
            // - `JavadocJar.Javadoc()` to publish standard javadocs
            // whether to publish a sources jar
            JavadocJar.None(),
            sourcesJar = true,
        )
    )
    pom {
        name.set("Vinner")
        description.set("Open source VIN validation library.")
        inceptionYear.set("2024")
        url.set("https://github.com/vinner-it/vinner-it-kotlin")
        licenses {
            license {
                name.set("The Apache License, Version 2.0")
                url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                distribution.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
            }
        }
        developers {
            developer {
                id.set("dev.vinner@gmail.com")
                name.set("Vinner")
                url.set("https://github.com/vinner-it/")
            }
        }
        scm {
            url.set("https://github.com/vinner-it/vinner-it-kotlin/")
            connection.set("scm:git:git://github.com/vinner-it/vinner-it-kotlin.git")
            developerConnection.set("scm:git:ssh://git@github.com/vinner-it/vinner-it-kotlin.git")
        }
    }
    publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL)

    signAllPublications()
}
