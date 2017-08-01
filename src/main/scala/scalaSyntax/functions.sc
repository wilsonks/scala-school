import scala.util.Random

object function {

  //To define a function
  //Specify Name,parameters & body
  //abs is a function which consumes a Double and yields a Double
  def abs(x: Double) = if (x >= 0) x else -x
  def abs1(x: Double)  {if (x >= 0) x else -x}//Error

  //Return type is mandatory for recursive functions
  //all other functions its optional
  def fact(n: Int): Int = if(n <= 0) return 1 else n* fact(n -1)
  def isWovel(ch: Char) = "aeiou".contains(ch)

  //Go thorough each cahracters, in case a Wovel yield to the collection
  def wowels(str: String) = for(ch <- str if isWovel(ch)) yield ch

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

  abs(-10)
  //When you define a function you make sure you add a = sign
  abs1(-10)//Error


  fact(4)
  fact(10)


  isWovel('e')
  isWovel('u')

  isWovel('z')

  wowels("aeiou")
  wowels("gangtok")
  wowels("dargling")

  randArray(2)

  Array(2,6,3,4,5)
  swapAdjacent(Array(6,2,4,3,5))

  assert(Array(2,6,3,4,5).deep == swapAdjacent(Array(6,2,4,3,5)).deep)
}
