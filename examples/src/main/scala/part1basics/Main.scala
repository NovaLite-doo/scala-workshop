package part1basics

import scala.collection.immutable.TreeSet

object Main extends App {

  // VALs are IMMUTABLE (preferred)
  // explicit type (recommend to add on public values)
  val name: String = "Jane"

  // omitting the type -> compiler will infer the type
  val anotherName = "John"

  // VARs are MUTABLE (rarely used)
  var example = "hello"
  example = "goodbye"

  // Class definition, (constructor) parameters are class fields and they are immutable by default and private
  class Person(val firstName: String, var lastName: String) {
    override def toString: String = s"$firstName $lastName"
  }
  // inaccessible
  //person.lastName

  val person = new Person("John", "Doe")
  println(person.firstName)
  println(person)

  // Define list, map, set

  val numbersList = List(1, 2, 3, 4, 5)
  val numbersFromRange = (1 to 5).toList

  // unordered by default (HashSet implementation)
  val numbersSet = Set(1, 1, 2, 2, 2, 3, 4, 5)

  val map: Map[Int, String] = Map(1 -> "1", 2 -> "2", 3 -> "3")

  println(numbersList)
  println(numbersFromRange)
  println(numbersSet)
  println(map)

}
