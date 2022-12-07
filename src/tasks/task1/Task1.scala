package tasks.task1

/** Create a list with all element combinations from two lists
  */
object Task1 extends App {
  val numbers = List(1, 2, 3, 4)
  val letters = List('a', 'b', 'c')
  val combinations =
    letters.flatMap(letter => numbers.map(number => s"$letter$number"))
  println(combinations)
}
