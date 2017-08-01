//reduceLeft applies a binary function to element couples going from left to right
//reduceLeft is applicable - Any operation involves all the elements
//1. multiplication
//2. sum
//3. concatenation (String)

object reduceLeftFun {
  (1 to 9).reduceLeft(_ * _)
  (1 to 10).reduceLeft(_ + _)

  def fact(n: Int) = (1 to n).reduceLeft(_*_)
  fact(4)

  //Function to compute 2 to the power of 16
  def pow(x: Int, y: Int) = ((1 to y).map(n => x)).reduceLeft(_ * _)
  pow(2,16)
  pow(3,3)

  def concatfun(strings: Array[String],sep: String) = {
    strings.reduceLeft(_ + sep + _)
  }
  concatfun(Array("mary","had","a","little","lamp")," ")
}