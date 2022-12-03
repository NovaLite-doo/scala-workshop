package models

import play.api.libs.json.{Json, Reads}

case class Snippet(
                    channelId: String,
                    title: String,
                    assignable: Boolean
                  )

object Snippet {
  implicit val reads: Reads[Snippet] = Json.reads[Snippet]
}
