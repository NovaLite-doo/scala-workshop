package services

import models.{Category, Video}
import repository.categoryRepository.CategoryRepository
import repository.videoRepository.VideoRepository

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
