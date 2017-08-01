
import java.io.FileNotFoundException

import scala.io.Source

object mapExcersize {

    //Read a file and find the occurances of each word in it
    //The Best way is to keep a map
  def countNumberOfWords(file: String) = {
    val resultMap = scala.collection.mutable.Map[String,Int]()

    val sourceBuffer = Source.fromFile(file)
    val sourceStrings = sourceBuffer.mkString.split("\\s+")
    for(str <- sourceStrings) {
      resultMap(str) = resultMap.getOrElse(str,0) + 1
    }
    resultMap
  }
    //Immutable Map variant
    //use + and - operators to update the map
  def withImmutableMapCountNumberOfWords(file: String) = {
    var resultMap = Map[String,Int]()

    val sourceBuffer = Source.fromFile(file)
    val sourceStrings = sourceBuffer.mkString.split("\\s+")
    for(str <- sourceStrings) {
      //The -> operator makes a map entry pair
      resultMap = resultMap + (str -> (resultMap.getOrElse(str,0)+1))
    }
    resultMap
  }

  countNumberOfWords("/home/wilson/kvs.txt")
  withImmutableMapCountNumberOfWords("/home/wilson/kvs.txt")
}
