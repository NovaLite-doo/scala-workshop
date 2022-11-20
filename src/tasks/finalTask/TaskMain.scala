package tasks.finalTask

import tasks.finalTask.repository.categoryRepository.LocalJsonCategoryRepository
import tasks.finalTask.repository.videoRepository.LocalCsvVideoRepository
import tasks.finalTask.services.StatisticsServiceTask

import scala.concurrent.duration.DurationInt
import scala.concurrent.{Await, ExecutionContext}

/** Implement methods in StatisticsServiceTask class so tests in
  * StatisticsServiceTaskSpec class pass.
  */
object TaskMain extends App {
  implicit val ec: ExecutionContext = ExecutionContext.global

  val categoryRepository = new LocalJsonCategoryRepository(
    getClass.getClassLoader.getResourceAsStream("finalTask/categories.json")
  )
  val videoRepository = new LocalCsvVideoRepository(
    getClass.getClassLoader.getResourceAsStream("finalTask/videos.csv")
  )

  val statisticsService =
    new StatisticsServiceTask(categoryRepository, videoRepository)

  Await.result(
    for {
      Some(videoWithMostViews) <- statisticsService.videoWithMostViews
      Some(videoWithLeastViews) <- statisticsService.videoWithLeastViews
      Some(categoryWithMostViews) <- statisticsService.categoryWithMostViews
      Some(categoryWithLeastViews) <- statisticsService.categoryWithLeastViews
      channelWithMostViewsForEachCategory <-
        statisticsService.channelWithMostViewsForEachCategory
    } yield {
      println(s"Video with most views is: '${videoWithMostViews.title}'")
      println(s"Video with least views is: '${videoWithLeastViews.title}'")
      println(
        s"Category with most views is: '${categoryWithMostViews.snippet.title}'"
      )
      println(
        s"Category with least views is: '${categoryWithLeastViews.snippet.title}'"
      )
      channelWithMostViewsForEachCategory.foreach {
        case (category, Some(channelTitle)) =>
          println(
            s"'$channelTitle' is most popular channel for category '${category.snippet.title}'"
          )
        case (category, None) =>
          println(s"There is no data for category '${category.snippet.title}'")
      }
    },
    10.minutes
  )
}
