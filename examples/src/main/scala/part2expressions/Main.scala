package part2expressions

object Main extends App{

  val x = 1 + 2
  val isEven = x % 2 == 0
  val isOdd = !isEven

  val condition = true

  // If is EXPRESSION and it will return value

  val conditionedResult: Int = if (condition) 42 else 0

  // result is Any type
  // else part doesn't exist and it will return unit (aka void in Java)
  val doNotWrite = if (condition) 42


  val codeBlock = {
    val condition = true
    if (condition) 42 else 0
  }

  // println returns return unit
  //val printResult: Unit = println(1)


}
