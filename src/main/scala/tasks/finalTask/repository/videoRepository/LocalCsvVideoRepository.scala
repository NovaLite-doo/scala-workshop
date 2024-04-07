package tasks.finalTask.repository.videoRepository

import com.github.tototoshi.csv.{CSVFormat, CSVReader, DefaultCSVFormat}
import tasks.finalTask.models.Video

import java.io.InputStream
import scala.concurrent.Future
import scala.io.Source
import scala.util.Using

class LocalCsvVideoRepository(makeInputStream: => InputStream)
    extends VideoRepository {

  private implicit val csvFormat: CSVFormat = new DefaultCSVFormat {}

  override def getAllVideos: Future[Seq[Video]] = Future.fromTry {
    Using(CSVReader.open(Source.fromInputStream(makeInputStream))) { reader =>
      reader.iteratorWithHeaders
        .map(Video.fromMap)
        .toSeq
    }
  }

}
