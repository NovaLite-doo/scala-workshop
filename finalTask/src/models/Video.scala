package models

import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat

case class Video(
                  videoId: String,
                  title: String,
                  channelTitle: String,
                  categoryId: Long,
                  tags: Seq[String],
                  views: Long,
                  likes: Long,
                  dislikes: Long,
                  commentTotal: Long,
                  thumbnailLink: String,
                  date: DateTime
                )

object Video {
  private val dateFormat = DateTimeFormat.forPattern("dd.MM")

  def fromMap(map: Map[String, String]): Video =
    Video(
      videoId = map("video_id"),
      title = map("title"),
      channelTitle = map("channel_title"),
      categoryId = map("category_id").toLong,
      tags = map("tags").split('|'),
      views = map("views").toLong,
      likes = map("likes").toLong,
      dislikes = map("dislikes").toLong,
      commentTotal = map("comment_total").toLong,
      thumbnailLink = map("thumbnail_link"),
      date = dateFormat.parseDateTime(map("date"))
    )
}
