object arrayGrouping {

  //groupBy method for Array is the best to solve algorithms
  val intArr = Array(1,22,333,44,55,23,6,5,7777)
  val mapData = intArr.groupBy(_.toString.size)
  mapData.getOrElse(1,None)
  mapData.getOrElse(2,None)
  mapData.getOrElse(3,None)
  mapData.getOrElse(4,None)
  mapData.getOrElse(5,None)

  //We have an Array of strings
  val arr = Array("Wilson","Wil","Binu","SaWiji","wifi","liWi","kWi")
  arr.groupBy(_.substring(0,2))
  //Get the number of strigs starts with Wi
  arr.groupBy(_.substring(0,2)).getOrElse("Wi",None)
  //Get the number of strigs ends with Wi - used reverse
  arr.groupBy(_.reverse.substring(0,2)).getOrElse("iW",None)

}