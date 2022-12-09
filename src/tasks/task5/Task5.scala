package tasks.task5

/** <ul> <li>Implement multiplySumBy2 method to return result sum of two numbers
  * multiplied by multiplier.</li> <li>Print multiplier from companion
  * object.</li> <li>Simplify creating new instance of Calculate class using
  * companion object.</li> </ul>
  * @note
  *   apply() method will help you to achieve this.
  */

class Calculate(numberOne: Int, numberTwo: Int) {
  def multiplySumBy2: Int = (numberOne+numberTwo)*Calculate.multiplier
}

object Calculate {
  private val multiplier = 2
  def apply(numberOne: Int, numberTwo: Int): Calculate = new Calculate(numberOne, numberTwo)
}


object Main extends App {
  val calculate: Calculate = ???
  println(calculate.multiplySumBy2)
}
