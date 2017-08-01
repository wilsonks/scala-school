//Scala supports Currying
//why currrying ?? Somtimes helps with Type Inference
//It helps reduce type syntax ( type inference )
//
object curryingFun {
  def multiply3(x: Int,y: Int) = x*y

  multiply3(2,3)

  def curryingMultiply(x:Int)(y:Int)(z:Int) = x * y *z
  curryingMultiply(2)(3)(4)

  val a = Array("Hello World")
  val b = Array("Hello World")

  a.corresponds(b)((x,y) => x.equalsIgnoreCase(y))
  a.corresponds(b)(_.equalsIgnoreCase(_)) //Curring helps here reduction in syntax
  a.corresponds(b)((x,y) => x.equalsIgnoreCase(y))

}