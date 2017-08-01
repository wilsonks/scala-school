//A function has access to any variable from any
// enclosing scope even if the variable
// is no longer around when you call the function
object closuresFun {

  def mulBy(factor: Double) = (x: Double) => factor * x
  val triple = mulBy(3)

}