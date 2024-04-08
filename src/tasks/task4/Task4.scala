package tasks.task4

/** Create a logic to check if a User is a minor or an adult:
 */

// Case class representing a User
case class User(username: String, age: Int)

// Companion object for User class
object User {
  // Method to validate user's age
  def isValid(user: User): Boolean = {
    if (user.age >= 18) {
      println(s"${user.username} is an adult.")
      true
    } else {
      println(s"${user.username} is a minor.")
      false
    }
  }

  /*
  //match case
   def isValid(user: User): Boolean = user.age match {
    case age if age >= 18 =>
      println(s"${user.username} is an adult.")
      true
    case _ =>
      println(s"${user.username} is a minor.")
      false
  }
   */
}

object Task4 extends App {

  val user1 = User("Alice", 25)
  val user2 = User("Bob", 16)

  User.isValid(user1)
  User.isValid(user2)

}

