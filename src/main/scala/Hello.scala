import scala.io.Source

object Hello extends App {
  val url = getClass.getResource("/example_1.json")
  val in  = Source.fromURL(url)

  println(getClass.getResource("/folder").getFile)

  println(in.getLines().toArray.mkString("\n"))
}