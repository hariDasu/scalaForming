name := """scalaForming"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.1"

libraryDependencies ++= Seq(
  jdbc,
  anorm,
  cache,
  ws,
  "org.webjars" %% "webjars-play" % "2.3.0-3",
  "org.webjars" % "jquery" % "2.1.1",
  "org.webjars" % "bootstrap" % "3.3.1",
  "org.webjars" % "react" % "0.13.0",
  "org.webjars" % "react-bootstrap" % "0.13.2",
  "org.webjars" % "jsx-requirejs-plugin" % "0.5.2",
  "org.webjars" % "flux" % "2.0.2"
)
