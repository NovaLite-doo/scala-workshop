package tasks.finalTask.repository.videoRepository

import tasks.finalTask.models.Video

import scala.concurrent.Future

trait VideoRepository {
  def getAllVideos: Future[Seq[Video]]
}
