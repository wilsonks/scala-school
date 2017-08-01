object classes {

   //Point Class.
  //Immutable classes - look at the val on the input parameters Cant change the val fields.
  //p.x and p.y can only be used to read not to mutate the instance fields.

  //Mutable classes are classes thier input paramerters/instanc e variables can be var.

  //Another important benefit of scala is that
  //you can replace an instance variable with a parameterless method.
  //no users of the class gets affected since instance variable and parameterless method are not diffrentiatable

  //Primary Constructor
  class Point(val x:Double, val y: Double){
    //Can also have private var or val
     private val first = (0.0,0.0)
     private var last = (0.0,0.0)

     println("Inside point")
     def move(dx: Double,dy:Double)= new Point(x+dx,y+dy)
     def distanceFromOrigin = math.sqrt((x * x) + (y * y))

     //All classes in scala extends java.lang.object
     //so for any scala class we need to override toString method
     //string interpolation unrelated topic set aside
     override def toString: String = f"(${x},${y})"
   }

  //Auxilary constructor
  class AuxPoint1(val x:Double,val y:Double) {
    println("Inside point1")
    def this()  { this(0, 0)}
    def move(dx: Double,dy:Double)= new Point(x+dx,y+dy)
    override def toString = f"(${x},${y})"
  }

  //Default Arguments instead of Auxilary Constructors
  class AuxPoint2(val x:Double=0,val y:Double = 0) {
    println("Inside point1")
    override def toString = f"(${x},${y})"
  }

  //No () for parameterless accessor methods such as distanceFromOrigin
  val p = new Point(12,13)
  //The input parameters turned to instance variables of the objects
  p.x
  p.y
  println("Distance From Origin " + p.distanceFromOrigin)


  val p1 = p.move(5,5)
  println("Distance From Origin " + p1.distanceFromOrigin)


  //Auxilary constructor
  val q = new AuxPoint1()
  q

  //Auxilary constructor
  val r = new AuxPoint2()
  r


  1 to 10 map (_*2)

}