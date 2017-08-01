object forloop {

  //Scala has WHILE loops
  //No Three-part FOR loop, an increment, a condition and an update
  //Instead you have for each loop
  //no Val or Var before i
  for(i <- 1 to 10) print(i + " ")
  for(i <- "Hello") print(i + " ")


  //All Features are shown below
  //1. Can have multiple Generators
  for(i <- 1 to 4; j <- 1 to 4) print(((i*10)+j)+ " ")

  //2. Can have Guards
  // When we use If statements inside for
  for(i <- 1 to 100 if i%2 != 0) print(i + " ")

  //3. Collecting Results
  //When we use yield along with for
  val res = for(i <- 1 to 10) yield i*2



  //write  a function to print the count down numbers
  def countDown(n: Int): Unit = {
    for(i <- n to (0,-1) ) println(i)
  }

  countDown(13)

  //Write a loop for computing the product of the unicodes for all letters in a string
  def mulUniCode(s: String) = {
    var result: Long = 1
    for(c <- s) result *= c.toLong
    result
  }

  //Cmpute the product of letters in a word without a loop
  def mulUnicode1(s: String) = {
    s.map(_.toLong).product
  }

  //Compute the product of letters in a word using recursive fuction
  def recMulUniCode(s: String): Long = {
    if(s.tail != "") s.head.toLong * recMulUniCode(s.tail) else s.head.toLong
  }

  assert(9415087488L == mulUniCode("Hello"))
  assert(9415087488L == mulUnicode1("Hello"))
  assert(9415087488L == recMulUniCode("Hello"))


}

