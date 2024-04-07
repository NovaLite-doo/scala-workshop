package tasks.finalTask.repository.categoryRepository

import tasks.finalTask.models.Category

import scala.concurrent.Future

trait CategoryRepository {
  def getAllCategories: Future[Seq[Category]]
}
