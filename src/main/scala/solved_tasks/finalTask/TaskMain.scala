package solved_tasks.finalTask

import scala.concurrent.{Await, ExecutionContext, Future}
import scala.io.StdIn
import sttp.client4.quick._
import sttp.client4.Response
import sttp.client4.httpclient.HttpClientFutureBackend
import sttp.model.StatusCode

import scala.concurrent.duration.DurationInt

/** Finish implementation of numbers guessing game. Replace ??? with the actual
  * code. <ol> <li>Parse string input</li> <li> Add input param validation <ul>
  * <li>Input needs to be integers</li> <li>There needs to be 7 numbers</li>
  * <li>Numbers need to be larger than 0</li> <li>Numbers need to be lower than
  * 40</li> </ul> </li> <li>If the combination is correct print:
  * "Congratulations, you won!!!"</li> <li>If the combination is not correct
  * print: "Winning combination was: ${winningCombination}. Better luck next
  * time."</li> </ol>
  */
object TaskMain extends App {
  implicit val ec: ExecutionContext = ExecutionContext.global
  val backend = HttpClientFutureBackend()

  def getWinningCombination: Future[Seq[Int]] = basicRequest
    .get(
      uri"http://www.randomnumberapi.com/api/v1.0/random?min=1&max=39&count=7"
    )
    .send[Future](backend)
    .map {
      case Response(Right(jsonString), StatusCode.Ok, _, _, _, _) =>
        ujson
          .read(ujson.Readable.fromString(jsonString))
          .arr
          .map(_.num.toInt)
          .toSeq
      case _ =>
        throw new Exception("Api returned non 200 response.")
    }

  println("Input your numbers(1-39) separated by whitespace: ")
  val usersCombination: Seq[Int] = {
    val inputString = StdIn.readLine()
    val splitString = inputString.trim.split("\\s+")
    if (splitString.size != 7) {
      throw new Exception("There needs to be 7 numbers")
    } else {
      val argsConvertedToInt = splitString.map(_.toInt)
      if (argsConvertedToInt.exists(n => n > 39 || n < 1)) {
        throw new Exception("Numbers need to be between 1 and 39")
      } else {
        argsConvertedToInt
      }
    }
  }

  Await.result(
    getWinningCombination
      .map {
        case winningCombination
            if winningCombination.equals(usersCombination) =>
          println("Congratulations, you won!!!")
        case winningCombination =>
          println(
            s"Wining combination was: ${winningCombination.mkString("[", ", ", "]")}. Better luck next time."
          )
      },
    1.minute
  )

}
