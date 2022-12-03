package repository.videoRepository

import com.github.tototoshi.csv.{CSVFormat, CSVReader, DefaultCSVFormat}
import models.Video

import java.io.File
import scala.concurrent.Future
import scala.util.Using

class LocalCsvVideoRepository(file: File) extends VideoRepository {

  private implicit val csvFormat: CSVFormat = new DefaultCSVFormat {}


  override def getAllVideos: Future[Seq[Video]] = Future.fromTry {
    Using(CSVReader.open(file)) { reader =>
      reader
        .iteratorWithHeaders
        .map(Video.fromMap)
        .toSeq
    }
  }

}
