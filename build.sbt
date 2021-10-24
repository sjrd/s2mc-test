ThisBuild / scalaVersion := "3.1.0"
ThisBuild / version := "0.1.0"

ThisBuild / name := "s2mc"

ThisBuild / resolvers += "Sonatype Public" at "https://oss.sonatype.org/content/groups/public/"

ThisBuild / semanticdbEnabled := true
ThisBuild / scalafixDependencies += "com.github.liancheng" %% "organize-imports" % "0.5.0"

ThisBuild / libraryDependencies ++= Seq(
  // cats libraries
  "org.typelevel" %% "cats-free" % "2.6.1",

  // effect libraries
  "org.typelevel" %% "cats-effect" % "3.2.2",
  // fs2.Chunk is used on protocol_core too
  "co.fs2" %% "fs2-core" % "3.1.0",

  // to make datatype-generic programming easier
  "org.typelevel" %% "shapeless3-deriving" % "3.0.2",

  // test libraries
  "org.scalatest" %% "scalatest" % "3.2.10" % "test",
  "org.scalatestplus" %% "scalacheck-1-15" % "3.2.10.0" % "test"
)

ThisBuild / scalacOptions ++= Seq(
  "-Yretain-trees",
  "-Xcheck-macros",
  "-Ykind-projector:underscores"
)

lazy val protocol_core =
  project.in(file("protocol-core"))

lazy val protocol_impl =
  project
    .dependsOn(protocol_core)
    .in(file("protocol-impl"))
    .settings(
      libraryDependencies ++= Seq(
        // effect libraries
        "co.fs2" %% "fs2-io" % "3.1.0",

        // our protocol implementation will use typenbt as a foundation to deal with NBTs
        ("net.katsstuff" %% "typenbt" % "0.5.1").cross(CrossVersion.for3Use2_13),

        // to easily deal with byte/bit vectors
        "org.scodec" %% "scodec-bits" % "1.1.28"
      )
    )

lazy val client_core =
  project
    .dependsOn(protocol_core)
    .in(file("client-core"))
    .settings(libraryDependencies ++= Seq("dev.optics" %% "monocle-core" % "3.0.0"))

lazy val examples =
  project.dependsOn(protocol_core, protocol_impl).in(file("examples"))
