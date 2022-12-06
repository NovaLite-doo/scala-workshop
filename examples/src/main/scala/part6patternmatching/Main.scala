package part6patternmatching

import scala.util.Random

object Main extends App {

  /** 1. <code>_</code> is wildcard, it is default case
    */

  val x = Random.nextInt(10)

  // Syntax
  val result = x match {
    case 0 => "Zero"
    case 1 => "One"
    case 2 => "Two"
    case _ => "Other"
  }

  println(x)
  println(result)

  // Matching on case class

  case class Rectangle(a: Int, b: Int)

  val rectangles = List(Rectangle(2, 2), Rectangle(2, 3))

  // If guard in pattern matching
  rectangles.foreach {
    case Rectangle(a, b) if a == b => println(s"Square with A: $a")
    case Rectangle(a, b)           => println(s"Rectangle with A: $a, B: $b")
  }
}
