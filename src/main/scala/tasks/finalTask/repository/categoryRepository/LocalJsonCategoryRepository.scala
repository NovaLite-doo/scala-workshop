package tasks.finalTask.repository.categoryRepository

import play.api.libs.json.Json
import tasks.finalTask.models.Category

import java.io.InputStream
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
