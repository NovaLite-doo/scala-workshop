package repository.categoryRepository

import models.Category
import play.api.libs.json.Json

import java.io.{File, FileInputStream}
import scala.concurrent.Future
import scala.util.Using

class LocalJsonCategoryRepository(file: File) extends CategoryRepository {
  override def getAllCategories: Future[Seq[Category]] =
    Future.fromTry {
      Using(new FileInputStream(file))(Json.parse)
        .map(json => (json \ "items").as[Seq[Category]])
    }
}
