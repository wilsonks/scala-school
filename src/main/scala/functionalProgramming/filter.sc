//filter retains the elements that fullfill a predicate
//(for comprehension + guard + yield)
object filterFun {
  (1 to 9).filter(_%2 == 0)
  for(i <- 1 to 9 if (i%2 == 0)) yield i
}