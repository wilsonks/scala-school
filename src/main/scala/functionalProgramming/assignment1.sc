import scala.collection.mutable.ArrayBuffer

object assignment {
  val zones = java.util.TimeZone.getAvailableIDs
  zones.map(s => s.split("/")).deep
  zones.map(s => s.split("/")).deep.length
  zones.map(s => s.split("/")).filter(_.length > 1).deep
  zones.map(s => s.split("/")).filter(_.length > 1).deep.length

  zones.map(s => s.split("/")).filter(_.length > 1).map(a => a(1))
  zones.map(s => s.split("/")).filter(_.length > 1).map(a => a(1)).length
  zones.map(s => s.split("/")).filter(_.length > 1).map(a => a(1)).grouped(10).toArray.map(a => a(1))

  var result:ArrayBuffer[String] = new ArrayBuffer()

  val fun = zones.map(s => s.split("/")).filter(_.length > 1).map(a => a(1)).grouped(10).foreach(arr => result += arr.reduceLeft((x,y) => x + " " + y))

//  result.foreach(str => println(str))
//  result.foreach(str => println(str))


  val cal = java.util.Calendar.getInstance().getTime
  val cal1 = scala.util.Random.nextInt(10)



}