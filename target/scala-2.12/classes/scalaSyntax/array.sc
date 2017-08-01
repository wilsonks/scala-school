import scala.util.Random

object array {
  //random number array from an interger input
  def randArray(n: Int) = new Array[Int](n).map(_ => Random.nextInt(n))

  //Swap adjacent numbers in an array
  def swapAdjacent(arr: Array[Int]) = {
    for(i <- 0 until arr.length if (i%2 == 0)) {
      var temp = arr(i)
      try {
        arr.update(i,arr(i+1))
        arr.update((i+1),temp)
      } catch {
        case _:ArrayIndexOutOfBoundsException => ()
      }
    }
    arr
  }

  randArray(2)

  Array(2,6,3,4,5)
  swapAdjacent(Array(6,2,4,3,5))

  assert(Array(2,6,3,4,5).deep == swapAdjacent(Array(6,2,4,3,5)).deep)

  assert(Array(2,6,3,4,5).size  == Array(2,6,3,4,5).length)


  //When declaring an array you need to specify the type
  val nums = new Array[Int](10)
  val strs = new Array[String](5)

  //No need for speScala can figure out its an array of strings
  val strs1 = Array("twinkle","twinkle","little","star")

  //Two ways to traverse
  val nums1 = for(n <- 0 until nums.length) yield (nums(n)+n)
  val nums2 = for(n <- nums) yield (n+1)

  strs1(0) = "Good Bye"
  strs1

  for(str <- strs1) print(str+" ")

  //To transform an Array -Use yield
  val arr = Array(1,2,3,4,5,6)
  for(ele <- arr) yield (ele*2)
  for(ele <- arr if ele%2 == 0) yield (ele*2)

  //All Commom Array algorithms are already part of scala
  Array(1,2,3,4,5,6).size
  Array(1,2,3,4,5,6).sum
  Array(1,2,3,4,5,6).max
  Array(1,2,3,4,5,6).reverse
  Array(1,4,2,3,6,4).sorted
  Array(1,2,3,4,5,6).mkString("|")
  Array(1,2,3,4,5,6).mkString("[","|","]").chars().toArray
  Array(1,2,3,4,5,6).mkString("").toArray

}