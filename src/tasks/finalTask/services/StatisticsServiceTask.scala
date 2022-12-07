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
  override def videoWithMostViews: Future[Option[Video]] =
    videoRepository.getAllVideos.map(_.maxByOption(_.views))

  override def videoWithLeastViews: Future[Option[Video]] =
    videoRepository.getAllVideos.map(_.minByOption(_.views))

  override def categoryWithMostViews: Future[Option[Category]] = for {
    categories <- categoryRepository.getAllCategories
    videos <- videoRepository.getAllVideos
    videosGroupedByCategory = videos.groupBy(_.categoryId).flatMap {
      case (categoryId, videos) =>
        categories.find(_.id.equals(categoryId)).map(_ -> videos)
    }
  } yield videosGroupedByCategory.view
    .mapValues(_.map(_.views).sum)
    .toMap
    .maxByOption(_._2)
    .map(_._1)

  override def categoryWithLeastViews: Future[Option[Category]] = for {
    categories <- categoryRepository.getAllCategories
    videos <- videoRepository.getAllVideos
    videosGroupedByCategory = videos.groupBy(_.categoryId).flatMap {
      case (categoryId, videos) =>
        categories.find(_.id.equals(categoryId)).map(_ -> videos)
    }
  } yield videosGroupedByCategory.view
    .mapValues(_.map(_.views).sum)
    .toMap
    .minByOption(_._2)
    .map(_._1)

  override def channelWithMostViewsForEachCategory
      : Future[Map[Category, Option[String]]] = for {
    categories <- categoryRepository.getAllCategories
    videos <- videoRepository.getAllVideos
    videosGroupedByCategory = videos.groupBy(_.categoryId).flatMap {
      case (categoryId, videos) =>
        categories.find(_.id.equals(categoryId)).map(_ -> videos)
    }
  } yield videosGroupedByCategory.view.mapValues { videos =>
    videos
      .groupBy(_.channelTitle)
      .view
      .mapValues(_.map(_.views).sum)
      .toMap
      .maxByOption(_._2)
      .map(_._1)
  }.toMap
}
