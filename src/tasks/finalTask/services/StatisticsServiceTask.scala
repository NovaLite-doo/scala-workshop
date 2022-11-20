package tasks.finalTask.services

import tasks.finalTask.models.{Category, Video}
import tasks.finalTask.repository.categoryRepository.CategoryRepository
import tasks.finalTask.repository.videoRepository.VideoRepository

import scala.concurrent.{ExecutionContext, Future}

class StatisticsServiceTask(
    categoryRepository: CategoryRepository,
    videoRepository: VideoRepository
)(implicit ec: ExecutionContext)
    extends StatisticsService {
  override def videoWithMostViews: Future[Option[Video]] = ???

  override def videoWithLeastViews: Future[Option[Video]] = ???

  override def categoryWithMostViews: Future[Option[Category]] = ???

  override def categoryWithLeastViews: Future[Option[Category]] = ???

  override def channelWithMostViewsForEachCategory
      : Future[Map[Category, Option[String]]] = ???
}
