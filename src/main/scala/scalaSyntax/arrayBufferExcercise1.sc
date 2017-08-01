import scala.collection.mutable.ArrayBuffer

//You are given an arrau biffer with positube and negatibe integers.
// Your task j is to remobe all nut the first nrgative number
object excercise {
  val arb = ArrayBuffer(1,-6,-2,-3,10,-14,8,-9,13)
  val arb1 = ArrayBuffer(1,-6,-2,-3,10,-14,8,-9,13)


  def removeAllButFirstNegetiveNumber1(buf: ArrayBuffer[Int]) = {
    //Collect the Negative number indexes in a List & Drop one element in the list
    //using for comprehension remove the elements from the buffer
    //Reverse the List so that element removal happens from the end of the array buffer
    val indexesToRemove = (for(i <- 0 until buf.length if buf(i) < 0) yield i).drop(1)
    for(index <- indexesToRemove.reverse) buf.remove(index)
  }
  def removeAllButFirstNegetiveNumber2(buf: ArrayBuffer[Int]) = {
    //Collect the Negative number indexes in a List & Drop one element in the list
    //Go through the list and collect a list of numbers which are not at indexesToRemove
    val indexesToRemove = (for(i <- 0 until buf.length if buf(i) < 0) yield i).drop(1)
    for(i <- 0 until buf.length if !indexesToRemove.contains(i)) yield buf(i)

  }

  removeAllButFirstNegetiveNumber1(arb)
  arb
  removeAllButFirstNegetiveNumber2(arb1).toArray

}