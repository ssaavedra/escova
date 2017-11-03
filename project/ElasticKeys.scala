import sbt._

/**
  * @author Santiago Saavedra (ssaavedra@openshine.com)
  */
trait ElasticKeys {
  lazy val esplugin = taskKey[File]("Creates an Elasticsearch plugin")
  lazy val espluginMetadataDir = settingKey[File]("Plugin metadata directory")
  lazy val elasticsearchVersion = settingKey[String]("The version of ES this " +
    "plugin is built for")

  lazy val espluginDescription = settingKey[String]("Plugin description")
  lazy val espluginClass = settingKey[String](
    "Which is the main class for the plugin")

}

object ElasticKeys extends ElasticKeys
