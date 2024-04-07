package examples.part5caseclass

import java.util.{Calendar, Date}

object Main extends App {
  case class Person(firstName: String, lastName: String, age: Int)

  /**   1. Case classes have an <code>apply</code> method by default and
    *      <code>new</code> keyword is not necessary <br/> 2. Parameters are
    *      public <code>val</code>s, it is not possible to reassign
    *      <i>firstName</i>, <i>lastName</i> or <i>age</i> <br/> 3. Instances of
    *      case classes are compared by structure and not by reference <br/> 4.
    *      <code>toString()</code> function is implemented by default
    */
  val person = Person("John", "Doe", 18)

  person.firstName // accessible outside of the class

  println(person)

  // Reassignment to val
  // person.firstName = "Jane"

  val copy = person.copy()
  val anotherPerson = person.copy("Jane")

  println(anotherPerson)
  println(person == copy)

  object Person {

    def apply(name: String, year: Int): Person = {
      val values = name.split(" ")
      val currentYear = Calendar.getInstance().getWeekYear
      Person(
        values.headOption.getOrElse(""),
        values.lift(1).getOrElse(""),
        currentYear - year
      )
    }
  }

  val p = Person("John Doe", 1990)
  println(p)
}
