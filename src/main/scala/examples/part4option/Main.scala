package examples.part4option

object Main extends App {

  // Option can be either Some[T] -> value exists or None -> value doesn't exist

  val optionalValue: Option[Int] = Option(1) // -> Some(1)

  val empty = Option.empty[Int] // -> None

  val fromNull = Option(null) // -> None

  // Or direct assignment
  val some: Option[Int] = Some(1)
  val none: Option[Int] = None

  println(optionalValue)
  println(empty)
  println(fromNull)

  // How to get value from Option

  // .get (not recommended) why?
  val getSome = Some(1).get
  println(getSome)

  // Will throw an exception
  // val getNone = None.get

  // access possible value from option
  optionalValue.foreach(println)

  val anotherOption =
    optionalValue.map(x => x + 1) // also returns an optional value

  // get with default value if option is empty
  val default = empty.getOrElse(0)

}
