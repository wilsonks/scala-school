//Match is a delux version of the switch statement
//Support Guards
object matchFun {

  //A Better Switch
  //No break
  //No default - case _ - case somethingElse
  val ch = '1'
  val sign = ch match {
    case 'a' => 1
    case 'b' => 0
    case _ if Character.isDigit(ch) => 10
    case _ => -1
  }

  //Case 'constants'
  var result: Int = -1
  ch match {
    case 'a' => result = 1
    case 'b' => result = 0
    case _ if Character.isDigit(ch) => result = 10
    case _ => result = -1
  }
  result

  //case var

  //case var: Type
  val obj: String = "Wilson"
  obj match {
    case x: Int => x
    case s: String => println(Integer.parseInt(s))
    case _: BigInt => Int.MaxValue
    case _ => 0
  }

}