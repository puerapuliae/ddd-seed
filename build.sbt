enablePlugins(JavaAppPackaging)
enablePlugins(DockerPlugin)

lazy val commonSettings = Seq(
  organization := "net.puerapuliae",
  version := "0.1.0",
  scalaVersion := "2.11.6",
  scalacOptions ++= Seq(
    "-deprecation"
    ,"-unchecked"
    ,"-encoding", "UTF-8"
    ,"-Xlint"
    ,"-Yclosure-elim"
    ,"-Yinline"
    ,"-Xverify"
    ,"-feature"
    ,"-language:postfixOps"
    ,"-optimise"
  ),
  libraryDependencies ++= Seq (
    "org.scalatest" %% "scalatest" % "2.2.4" % "test",
    "org.scalacheck" %% "scalacheck" % "1.12.2",
    "org.rocksdb" % "rocksdbjni" % "3.10.1"
  ),
  fork := true,
  scalaSource in Compile := baseDirectory.value / "src",
  scalaSource in Test := baseDirectory.value / "src",
  excludeFilter in (Compile, unmanagedSources) := HiddenFileFilter || "*_test.scala",
  excludeFilter in (Test, unmanagedSources) := HiddenFileFilter,
  resourceDirectory in Compile := baseDirectory.value / "resources",
  resourceDirectory in Test := baseDirectory.value / "resources",
  defaultLinuxInstallLocation in Docker := "/opt/docker",
  dockerExposedPorts := Seq(3000, 8080),
  dockerBaseImage := "puerapuliae/java"
)

lazy val root = (project in file(".")).
  aggregate(domain, application, infrastructure).
  settings(commonSettings: _*).
  settings(
      name := "ddd-seed"
  )

lazy val domain = project.settings(commonSettings: _*)

lazy val application = project.
  settings(commonSettings: _*).
  dependsOn(domain, infrastructure)

lazy val infrastructure = project.
  settings(commonSettings: _*).
  settings(
    libraryDependencies ++= Seq (
      "com.typesafe.akka" % "akka-http-core-experimental_2.11" % "1.0",
      "com.typesafe.akka" % "akka-http-experimental_2.11" % "1.0"
    )
  )
