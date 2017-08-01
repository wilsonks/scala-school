object patternMatchRegExp extends App {
  println("Welcome to Pattern Matching with Regular Expressions in Scala")

  import scala.util.matching.Regex


  val LineEntry1 = new Regex("""Completed in (\d+)ms""")
  val LineEntry2 = ("""Completed in (\d+) ms""").r //Strings have a method called "r"
                                                  // which wil convert it to Regex object

  val line = "Completed in 90ms"
//  val line = "Completed in 90 ms"

  line match {
//    case LineEntry1(time) => println(f"LineEntry1 ($time)")
    case LineEntry1(time) => println("LineEntry1 %d ms".format(time.toInt))
    case LineEntry2(time) => println((time.toInt))
  }

}