name := "escova"

enablePlugins(GitVersioning)
enablePlugins(ElasticPlugin)

espluginClass := "com.openshine.escova.esplugin.EscovaPlugin"
espluginDescription :=
  """
    |ESCOVA is a Cost Analyzer and Validation Assistant for ES Queries
  """.stripMargin.trim

libraryDependencies ++= Seq(
  "com.typesafe" % "config" % "1.3.0",
  "com.iheart" %% "ficus" % "1.4.7",
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
