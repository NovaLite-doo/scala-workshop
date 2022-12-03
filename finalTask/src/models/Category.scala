package models

import org.apache.commons.lang3.exception.ExceptionUtils
import play.api.libs.json.{JsError, JsObject, JsSuccess, Reads}

import scala.util.Try

case class Category(id: Long, kind: String, etag: String, snippet: Snippet)

object Category {
  implicit val reads: Reads[Category] = Reads[Category] {
    case obj: JsObject =>
      Try(
        Category(
          (obj \ "id").as[String].toLong,
          (obj \ "kind").as[String],
          (obj \ "etag").as[String],
          (obj \ "snippet").as[Snippet]
        )
      ).fold(t => JsError(ExceptionUtils.getStackTrace(t)), c => JsSuccess(c))
    case _ =>
      JsError("Can't parse the category, json provided is not an object")
  }
}
