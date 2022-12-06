class Calculate(numberOne: Int, numberTwo: Int) {

  def getResult(): Int = {
    (numberOne + numberTwo) * Calculate.MULTIPLIER
  }
}

object Calculate {

  private val MULTIPLIER: Int = 2

  def apply(numberOne: Int, numberTwo: Int): Calculate = {
    new Calculate(numberOne, numberTwo)
  }
}

object Task4 extends App {
  val calculate = Calculate(4, 3)
  println(calculate.getResult())
}

