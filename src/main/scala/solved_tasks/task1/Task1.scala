package solved_tasks.task1

/** Create a list with all element combinations from two lists
  */
object Task1 extends App {
  val numbers = List(1, 2, 3, 4)
  val letters = List('a', 'b', 'c')
  val combinations = numbers.flatMap(n => letters.map(l => s"$n$l"))
  println(combinations)
}
