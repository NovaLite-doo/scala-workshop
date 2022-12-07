import repository.categoryRepository.LocalJsonCategoryRepository
import repository.videoRepository.LocalCsvVideoRepository
import services.StatisticsServiceTaskSolved

import java.io.File
import scala.concurrent.duration.DurationInt
import scala.concurrent.{Await, ExecutionContext}

/** Implement methods in StatisticsServiceTask class so tests in
  * StatisticsServiceTaskSpec class pass.
  */
object SolvedTaskMain extends App {
  implicit val ec: ExecutionContext = ExecutionContext.global

  val categoryRepository = new LocalJsonCategoryRepository(
    new File(
      getClass.getClassLoader.getResource("categories.json").toURI
    )
  )
  val videoRepository = new LocalCsvVideoRepository(
    new File(getClass.getClassLoader.getResource("videos.csv").toURI)
  )

  val statisticsService =
    new StatisticsServiceTaskSolved(categoryRepository, videoRepository)

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
