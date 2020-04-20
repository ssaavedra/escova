name := "escova-core"

organization := "eu.ssaavedra"

organizationName := "ssaavedra"

enablePlugins(GitVersioning)

libraryDependencies ++= Seq(
  "org.elasticsearch" % "elasticsearch" % "5.6.3" % "provided",
  "org.json4s" %% "json4s-native" % "3.6.7"
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
  "org.scalactic" %% "scalactic" % "3.1.1" % Test
)

licenses := Seq(
  "Apache-2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0.txt")
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
