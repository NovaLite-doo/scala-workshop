package repository.categoryRepository

import models.Category

import scala.concurrent.Future

trait CategoryRepository {
  def getAllCategories: Future[Seq[Category]]
}
