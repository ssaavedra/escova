package com.openshine.escova

import org.scalatest.{FlatSpec, Matchers}

/**
  * @author Santiago Saavedra (ssaavedra@openshine.com)
  */
class ParserTest extends FlatSpec with Matchers {

  def sample1: String =
    """
      |{
      |  "aggs": {
      |    "titles": {
      |      "terms": {
      |        "field": "title"
      |      },
      |      "meta": {
      |        "color": "blue"
      |      }
      |    },
      |    "my_unbiased_sample": {
      |      "diversified_sampler": {
      |        "shard_size": 200,
      |        "field": "author"
      |      },
      |      "aggs": {
      |        "keywords": {
      |          "significant_terms": {
      |            "field": "tags",
      |            "exclude": [
      |              "elasticsearch"
      |            ]
      |          }
      |        }
      |      }
      |    }
      |  }
      |}
    """.stripMargin

  def sample2: String =
    """
      |{
      |  "query": {
      |    "range": {
      |      "date": {
      |        "gte": "20170120T293910",
      |        "lte": "200170120T293920"
      |      }
      |    }
      |  },
      |  "aggs": {
      |    "2": {
      |      "terms": {
      |        "field": "fields.keyword",
      |        "size": 10
      |      },
      |      "aggs": {
      |        "1": {
      |          "date_histogram": {
      |            "field": "date",
      |            "interval": "month"
      |          }
      |        },
      |        "2": {
      |          "terms": {
      |            "field": "fields.keyword",
      |            "size": 10
      |          }
      |        }
      |      }
      |    }
      |  }
      |}
    """.stripMargin

  "parser with sample1" should "have complexity 3.0" in {
    assert (Parser.parse(sample1, "idx", "type").value === 12.0 +- 0.1)
  }

  "parser with sample2" should "have complexity 10" in {
    assert (Parser.parse(sample2, "idx", "type").value === 110.0 +- 0.1)
  }

  "dateMathExpressionToSeconds" should
    "have a second equal a second (1000 ms)" in {
    Parser.dateMathExpressionToSeconds("1s") should be (1000L)
  }

  it should "have a month equal its millisecond amount" in {
    Parser.dateMathExpressionToSeconds("1M") should equal (
      31L * 24L * 3600L * 1000L)
  }

  it should "have a year equal its millisecond amount" in {
    Parser.dateMathExpressionToSeconds("1y") should equal (
      365L * 24L * 3600L * 1000L
    )
  }

  it should
    "support names such as 'month' or 'year' instead of '1M' or '1y'" in {
    Parser.dateMathExpressionToSeconds("month") should equal(Parser
      .dateMathExpressionToSeconds("1M"))

    Parser.dateMathExpressionToSeconds("year") should equal(Parser
      .dateMathExpressionToSeconds("1y"))
  }

}
