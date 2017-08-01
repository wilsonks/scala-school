object patternMatchAnyList extends App {
  println("Welcome to pattenMatchAnyList")

  //Write a function which accepts any List and return a String states the type of the List
  def checkList(list: List[Any]): String = {
    list match {
      case Nil => "Empty"
      case (head: Int)::tail => "Int"
      case (head: Double)::tail => "Double"
      case (head: String)::tail => "String"
      case (head: Char)::tail => "Char"
      case _ => "Unknown"
    }
  }

  println(checkList("Hello".toList))
  println(checkList(List(1, 2, 3, 4)))
  println(checkList(List("Wilson", "K", "Sam")))
  println(checkList(List(1.0, 2.0, 3.0)))
  println(checkList(List()))


}