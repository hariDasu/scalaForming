name := """scalaForming"""

version := "1.0-SNAPSHOT"


lazy val root = (project in file(".")).enablePlugins(SbtWeb,PlayScala)

resolvers += Resolver.sonatypeRepo("snapshots")


scalaVersion := "2.11.1"

libraryDependencies ++= Seq(
  jdbc,
  anorm,
  cache,
  ws,
  "org.webjars" %% "webjars-play" % "2.3.0-3",
  "org.webjars" % "jquery" % "2.1.1",
  "org.webjars" % "bootstrap" % "3.3.1",
  "ws.securesocial" %% "securesocial" % "master-SNAPSHOT"
)
