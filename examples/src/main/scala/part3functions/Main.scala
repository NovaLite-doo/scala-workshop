package part3functions

object Main extends App {

  def isEven(x: Int): Boolean = x % 2 == 0
  def increment(x: Int): Int = x + 1
  def double(x: Int): Int = x * 2

  val numbers = List(3, 4, 1, 7, 2, 4, 6, 8, 10)

  // pass function to as argument
  val doubledNumbers = numbers.map(double)

  // use an anonymous(inline) defined function
  val anonymousFunc = numbers.map(x => x * 2)

  // syntactic sugar for previous example, often used
  val anotherAnonymousFunc = numbers.map(_ * 2)

  // it is possible to chain functions
  val chainFunctions = numbers
    .filter(_ % 2 == 0)
    .map(_ + 1)
    .map(_ * 2)

  chainFunctions.foreach(println)
  // short version of
  //chainFunctions.foreach(number => println(number))

  // return type inference (not possible for recursive methods)
  def squareOf(x: Int) = x * x

  // Recursion (stack vs tail)
  def factorialStack(n: Long): Long =
    if (n == 0) 1 else n * factorialStack(n - 1)

  def factorialTail(n: Long): Long = {
    def fact(n: Long, acc: Long): Long = {
      if (n == 0) acc else fact(n - 1, n * acc)
    }

    fact(n, 1)
  }

  println(factorialTail(3))

  def isPalindrome(input: String): Boolean = {
    var result = true
    for (i <- 0 until input.length) {
      if (input.charAt(i) != input.charAt(input.length - 1 - i)) {
        result = false
      }
    }
    result
  }

  val input = "123321"

  def isPalindromeRec(input: String): Boolean = {
    if (input.length <= 1) {
      true
    } else {
      if (input.charAt(0) != input.charAt(input.length - 1)) {
        false
      } else {
        isPalindromeRec(input.drop(1).dropRight(1))
      }
    }
  }

  def isPalindromeRev(input: String): Boolean = input == input.reverse

  println(isPalindrome(input))
  println(isPalindromeRec(input))
  println(isPalindromeRev(input))
}
