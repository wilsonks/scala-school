object patternMatch2 extends App {
  println("Welcome to Pattern Match Problem 2")
  println("selector match { alternatives}")

  //What the problem manipulates - Expression
  sealed abstract class Expr
  //Types of Expressions being considered
  //using a case modifier makes the scala compiler add some syntactic
  //conveniences to your class.
    //1.A factory method with the name of the class- Avoids new
    //2.All the arguments get a val prefix, and maintained as fields
    //3.compiler add toString,hashCode,and equals to your class

  //sealed is a licence to pattern match

  //1. Variable Expression object
  case class Var(name: String) extends Expr
  //2.  Number Expression object
  case class Number(num: Double) extends Expr
  //3. Unary Operator object
  case class UnaryOp(operator: String, arg: Expr) extends Expr
  //4. Binary Operator object
  case class BinOp(operator:String,left: Expr,right:Expr) extends Expr

  def eval(e: Expr): Double = {
    e match {
      case Number(num) => num
      case Var(e) => e.toDouble
      case UnaryOp("-",element) => -(eval(element))
      case BinOp("+",left,right) => eval(left) + eval(right)
      case BinOp("*",left,right) => eval(left) * eval(right)
    }
  }

  var x = "20"


  var expr1 = BinOp("+",Number(10),Number(2))
  var expr2 = BinOp("*",Number(10),Number(2))
  var expr3 = UnaryOp("-",Number(10))
  var expr4 = BinOp("*",Number(10),UnaryOp("-",Number(10)))
  var expr5 = BinOp("*",Var(x),UnaryOp("-",Number(2)))

  println(eval(expr1))
  println(eval(expr2))
  println(eval(expr3))
  println(eval(expr4))
  println(eval(expr5))

}