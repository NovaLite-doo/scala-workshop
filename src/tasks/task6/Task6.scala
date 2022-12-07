package tasks.task6

/** Using pattern matching create function that will greet each user type
  * differently
  */
object Task6 extends App {
  val users = Seq(
    User.Guest(),
    User.RegisteredUser("johnDoe", Some("John Doe")),
    User.RegisteredUser("janeDoe", None),
    User.Admin("petarPetrovic"),
    new User {}
  )

  def greet(user: User): Unit = user match {
    case User.Guest()                           => println("Hello guest user")
    case User.RegisteredUser(_, Some(fullName)) => println(s"Hello $fullName")
    case User.RegisteredUser(username, None)    => println(s"Hello $username")
    case User.Admin(username) =>
      println(s"Hello $username, you are logged in as an admin user")
    case _ => println("Hello unknown user")
  }

  users.foreach(greet)
}
