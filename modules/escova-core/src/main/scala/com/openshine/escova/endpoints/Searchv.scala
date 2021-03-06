package com.openshine.escova.endpoints

import com.openshine.escova.{CostConfig, Parser}
import org.elasticsearch.search.builder.SearchSourceBuilder
import org.json4s._
import org.json4s.JsonDSL._

/**
  * @author Santiago Saavedra (ssaavedra@openshine.com)
  */
object Searchv {
  def apply(searchSourceBuilder: SearchSourceBuilder,
            costConfig: CostConfig): JValue = {
    Map(
      "cost" -> Parser.analyze(searchSourceBuilder)(costConfig).value
    )
  }
}
