package tasks.task4

/** For given list of users, calculate total age for each first name
  */
object Task4 extends App {
  val users = List(
    User("Bob", "Perry", 15),
    User("James", "Freeman", 22),
    User("Mary", "Hewitt", 20),
    User("James", "Jordan", 10),
    User("Bob", "Sims", 18),
    User("James", "Matthews", 30)
  )

  val nameAgeSumMap: Map[String, Int] =
    users.groupMapReduce(_.firstName)(_.age)(_ + _)

  println(nameAgeSumMap)
}

case class User(firstName: String, lastName: String, age: Int)
