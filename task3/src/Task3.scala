/**
 * Using pattern matching create function that will greet each user type differently
 */
object Task3 extends App {
  val users = Seq(
    User.Guest(),
    User.RegisteredUser("johnDoe", Some("John Doe")),
    User.RegisteredUser("janeDoe", None),
    User.Admin("petarPetrovic"),
    new User {}
  )

  def greet(user: User): Unit = ???

  users.foreach(greet)
}
