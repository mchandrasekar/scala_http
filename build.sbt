name := "finch-template"

version := "0.0.1-SNAPSHOT"

scalaVersion := "2.11.8"
lazy val circeVersion = "0.6.1"
EclipseKeys.withSource := true

libraryDependencies ++= Seq(
  "com.github.finagle" % "finch-core_2.11" % "0.11.1",
  "com.github.finagle" % "finch-circe_2.11" % "0.11.1",
  "io.circe" %% "circe-generic" % circeVersion
)
