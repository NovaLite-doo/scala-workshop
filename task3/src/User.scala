trait User
object User {
  case class Guest() extends User
  case class RegisteredUser(username: String, fullName: Option[String])
      extends User
  case class Admin(username: String) extends User
}
