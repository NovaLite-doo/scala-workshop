package tasks.task7

import scala.concurrent.duration.DurationInt
import scala.concurrent.{Await, ExecutionContext, Future}

/** Create a list with all element combinations from two lists
  */
object Task7 extends App {
  implicit val ec: ExecutionContext = ExecutionContext.global

  val numbers: Future[List[Int]] = Future {
    Thread.sleep(1000)
    List(1, 2, 3, 4)
  }
  val letters: Future[List[Char]] = Future {
    Thread.sleep(500)
    List('a', 'b', 'c')
  }
  val combinations: Future[List[String]] = for {
    numbersList <- numbers
    lettersList <- letters
  } yield lettersList.flatMap(letter =>
    numbersList.map(number => s"$letter$number")
  )

  println(combinations)
  Await.result(combinations.map(println), 1.minute)
}
