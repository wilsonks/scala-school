import java.awt.geom.{Ellipse2D, Rectangle2D}
object part1 {

  //The java.awt class has useful methods translate and grow that are unfotunatly absent
  //frm classed such as java.awt.geom.Ellipse2D.
  //In scala you can fix such problems. Define a trait and add concrete methods for translate and grow


  import java.awt._

  trait RectangleLike {
    this: java.awt.geom.Ellipse2D =>
    def translate(dx: Double,dy: Double): Unit ={
      setFrame(getX + dx, getY+dy,getWidth,getHeight)
    }
    def grow(dw: Double, dh:Double): Unit = {
      setFrame(getX,getY,getWidth+dw,getHeight+dh)
    }
    override def toString = f"[x=$getX,y=$getY,width=$getWidth,height=$getHeight]"
  }

  val r = new Rectangle(5,10,20,30)
  r.translate(10,10)
  r.translate(10,10)
  r

  val egg = new Ellipse2D.Double(5,10,20,30) with RectangleLike
  egg
  egg.translate(10,10)

  assert(egg.getX == 15)
  assert(egg.getX == 15)

  egg.grow(30,20)

  assert(egg.getWidth  == 50)
  assert(egg.getHeight == 50)


}