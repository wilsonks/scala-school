object matchExercise {

  //Swap elements in a pair
  def swap (p: (Int,Int)) = {
    p match {
      case (x,y) => (y,x)
    }
  }

  //Swap first 2 elements of an Integer Array
  def swap(arr: Array[Int]) = {
    arr match {
      case Array(x,y, rest @ _*) => Array(y,x) ++ rest
      case _ => arr
    }
  }

  swap((2,3))
  swap((3,4))

  swap(Array(1,2,3,4))
  swap("Hello".toCharArray.map(c => c.toInt)).map(i => i.toChar).mkString("")

}