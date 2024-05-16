import com.vanniktech.maven.publish.JavadocJar
import com.vanniktech.maven.publish.KotlinMultiplatform
import com.vanniktech.maven.publish.SonatypeHost

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    id("com.vanniktech.maven.publish") version "0.28.0"
}

kotlin {
    jvm()

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

mavenPublishing {
    coordinates(
        groupId = "io.github.vinner-it",
        artifactId = "vinner-it-kotlin",
        version = "1.1.0"
    )
    configure(
        KotlinMultiplatform(
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
