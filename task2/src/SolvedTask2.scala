object SolvedTask2 extends App {
  val strings = List("1", "2", "123", "1a", "20", "asd")
  val numbers = strings.flatMap(_.toIntOption)
  println(numbers)
}
