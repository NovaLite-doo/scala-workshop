package repository.videoRepository

import models.Video

import scala.concurrent.Future

trait VideoRepository {
  def getAllVideos: Future[Seq[Video]]
}
