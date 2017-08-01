//Reading File Content
import java.io._

import scala.io.Source

object fileOperation {

  Source.fromFile("/home/wilson/workspace/ScalaForTheImpatiant/target/scala-2.12/classes/example_1.json").foreach(print)

  //Get the URL of a resource file - example_1.jason
  val resourceFileURL = getClass.getResource("/example_1.json")
  val resourceFileURL1 = getClass.getResource("/folder/example_2.json")

  //Get the buffered Source from the URL
  val bufferedReader = Source.fromURL(resourceFileURL)
  val bufferedReader1 = Source.fromURL(resourceFileURL)
  val bufferedReader2 = Source.fromURL(resourceFileURL)


  bufferedReader.getLines().toArray.map(s => println(s))
  bufferedReader1.getLines().toArray.mkString("\n")

  val fis = new FileInputStream("/home/wilson/workspace/ScalaForTheImpatiant/target/scala-2.12/classes/example_1.json")
  for(i <- (1 to fis.getChannel.size().toInt)) println(fis.read().toChar)
  fis.close()

  val fr = new FileReader("/home/wilson/workspace/ScalaForTheImpatiant/target/scala-2.12/classes/example_1.json")
  fr.getEncoding
  while(fr.ready()) {
    println(fr.read().toChar)
  }
//  fr.read().toChar
  fr.close()

}