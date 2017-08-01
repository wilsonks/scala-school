object zip {
  //zip function works on two individual collections to a collection of pairs
  //For Example
  //You have a set of Integers
  //you have an array of Strings
  
  val numbers = Array(2,40,2)
  val symbols = Array("<","#",">")
  val myMapData = symbols.zip(numbers)
  for((left,right) <- myMapData) print(left*right)


}