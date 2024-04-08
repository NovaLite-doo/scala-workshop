package examples.part7futures

import sttp.client4.quick._
import sttp.client4.Response
import sttp.client4.httpclient.HttpClientFutureBackend
import sttp.model.StatusCode

import scala.concurrent.duration.DurationInt
import scala.concurrent.{Await, ExecutionContext, Future}

object Main extends App {
  implicit val ec: ExecutionContext = ExecutionContext.global
  val backend = HttpClientFutureBackend()
  val request = basicRequest
    .get(uri"https://api.math.tools/numbers/nod")
    .send[Future](backend)

  println(request)
  Await.result(
    request.map {
      case Response(body, StatusCode.Ok, _, _, _, _) =>
        body.foreach { jsonString =>
          val json = ujson.read(ujson.Readable.fromString(jsonString))
          println(json("contents")("nod")("numbers")("number"))
        }
      case _ =>
        println("Got non 200 response")
    },
    1.minute
  )
}
