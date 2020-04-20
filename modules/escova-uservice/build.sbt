name := "escova-akka-uservice"

organization := "eu.ssaavedra"

organizationName := "ssaavedra"

enablePlugins(GitVersioning)
enablePlugins(JavaAppPackaging)
enablePlugins(DockerPlugin)

libraryDependencies ++= Seq(
  "org.elasticsearch" % "elasticsearch" % "5.6.3",
  "com.typesafe.akka" %% "akka-http" % "10.1.11",
  "com.typesafe.akka" %% "akka-stream" % "2.5.31",
  "com.typesafe" % "config" % "1.4.0",
  "com.iheart" %% "ficus" % "1.4.7"
  // Warning: Do not use Jackson due to dependency hell against
  // elasticsearch
  // as Elasticsearch does not include some jackson modules needed by
  // json4s.
  // If such is needed, require json4s-jackson with notTransitive(), but
  // that
  // should be avoided while possible.
)

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "3.1.1" % Test,
  "org.scalactic" %% "scalactic" % "3.1.1" % Test,
  "com.typesafe.akka" %% "akka-http-testkit" % "10.1.11" % Test
)

licenses := Seq(
  "Apache-2.0" -> url("http://www.apache.org/licenses-LICENSE-2.0.txt"),
  "MIT License" -> url("http://www.opensource.org/licenses/mit-license.php")
)

developers := List(
  Developer("ssaavedra",
    "Santiago Saavedra",
    "@ssaavedra",
    url("https://gitlab.com/ssaavedra.eu"))
)

scmInfo := Some(
  ScmInfo(url("https://gitlab.com/ssaavedra.eu/escova"),
    "git@gitlab.com:ssaavedra.eu/escova.git")
)
