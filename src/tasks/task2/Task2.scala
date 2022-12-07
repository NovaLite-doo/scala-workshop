package tasks.task2

/** Capitalize the first letter of each word in sentence
  */
object Task2 extends App {
  val text: String = "this is a simple text."
  val textWithFirstLettersCapitalized: String =
    text.split(' ').map(_.capitalize).mkString(" ")
  println(textWithFirstLettersCapitalized)
}
