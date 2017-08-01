import scala.collection.mutable.ArrayBuffer

object arrayBuffer {
  val buf = ArrayBuffer("Mary","had","a","little","lamp")
  buf+= "-"                     //Add an lement at the end
  buf++= Array("little","lamp") //Append an Array
  buf.remove(3)                 //Remove an element from a position
  buf
  buf.insert(3,"little")
  buf

  //Conversion between Array and arrayBuffer
  buf.toArray
  buf.toBuffer


}