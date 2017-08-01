import java.util.Calendar

object mixinLayersTraits {
  //how Layering of traits works

  trait logged {
    def log(msg:String) {}
  }

  trait consoleLogger extends logged {
    override def log(msg: String): Unit = println(msg)
  }

  trait shortLogger extends logged {
    val maxLength = 46
    override def log(msg: String): Unit = {
      if(msg.length <= maxLength) super.log(msg)
      else super.log(msg.substring(0, maxLength-3) + "...")
    }
  }

  trait timeStampLogger extends logged {
    override def log(msg: String): Unit = super.log(new java.util.Date() + " " + msg)
  }

  class savingsAccount extends logged {
    private var balance:Double = 0
    def withdraw(amount: Double): Unit = {
      if(amount > balance) log("Insufficient funds")
      else balance -=amount
    }
  }

  //In case of Layered traits the evaluation happens from right to left
  //Here timeStampLogger called first then the Consolelogger
  val myAccount = new savingsAccount with consoleLogger with shortLogger with timeStampLogger {
    override val maxLength: Int = 40
  }
  myAccount.withdraw(1000)


}