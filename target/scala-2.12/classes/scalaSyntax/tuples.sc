object tuples {
  //Aggregates values of different types
  //Aggregates 3 types of values
  val t1 = (1,1,1)
  val t2 = (1,2.3,"Wilson")
  val t3 = ("Binu",900,0)

  //To access them use ._ method
  //Tuples position start with 1
  t3._1
  t3._2
  t3._3

  //Better to use with pattern matching
  //Someone gives you a tuple, use the below way to break them.
  //Dontcare elements can be handles with _ character
  val (first,second,third) = t3
  val (first1,_,_) = t3

  
}