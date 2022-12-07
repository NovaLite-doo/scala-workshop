package repository.categoryRepository

import models.Category
import play.api.libs.json.Json

import java.io.{File, FileInputStream, InputStream}
import scala.concurrent.Future
import scala.util.Using

class LocalJsonCategoryRepository(makeInputStream: => InputStream)
    extends CategoryRepository {
  override def getAllCategories: Future[Seq[Category]] =
    Future.fromTry {
      Using(makeInputStream)(Json.parse)
        .map(json => (json \ "items").as[Seq[Category]])
    }
}
