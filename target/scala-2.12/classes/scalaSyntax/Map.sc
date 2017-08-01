object map {

  //The -> operator makes a map pair
  //Collects key value pairs
  val scores = Map("Alice" -> 10, "Bob" -> 3, "Cindy"-> 8)
  val mscores = scala.collection.mutable.Map("Ajay" -> 9)

  //To get the value
  val val1 = scores("Alice")
  val val2 = scores.getOrElse("Wilson",None)
  //Always use getOrElse instead of () operator
  val val3 = scores.getOrElse("Bob",None)

  //To mutate the Map
  mscores
  mscores("Ajay")
  mscores.size
  mscores+= ("Wilson" -> 10)
  mscores.size
  mscores+= ("Vijay" -> 11)
  mscores.size
  mscores-=("Ajay")
  mscores.size

  mscores.update("Wilson",12)
  mscores

  //Iterating Over Maps
  //Easy with for loop
  val sal = Map("Binu" -> 900,"Joni" -> 900, "Wilson" -> 900,"Alex" -> 800, "Vinod" -> 700, "Saji" -> 700, "Ajin" -> 700)
  val account = Map("Binu" -> 900,"Joni" -> 900, "Wilson" -> 900,"Alex" -> 800, "Vinod" -> 700, "Saji" -> 700, "Ajin" -> 700)

  val accountJan21 = for((k,v) <- account)  yield (k,(v+sal(k)))
}