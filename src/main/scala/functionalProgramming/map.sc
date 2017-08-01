//1. map applies a function to each element of a sequence
//2. (for comprehension + yield)
object map {
  println("Welcome To map functionality")
  (0 to 9).map(.1*_)
  for(i <- 0 to 9) yield (.1*i)

  (for(i <- 0 to 9) yield (.1*i))

  (9 to (0,-1)).map(_ << 4)

}