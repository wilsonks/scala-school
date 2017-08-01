import java.io.PrintWriter

//Scala IO library does not have a builtin to support Writing into
// a file. In those case java.io is an alternate
object writeFun {

  //Open a File for Write
  val out = new PrintWriter("/home/wilson/workspace/ScalaForTheImpatiant/src/test/resources/test.txt")
  //Write
  (0 to 20).map(i => 9).map(x => out.println("%7d".format(x.toInt)))

  //Have to Check for write errors exclusively
  out.checkError()
  //Close the file
  out.close()

}