import org.joda.time.DateTime

object testFoldLeft {

  //Define a Table Row
  case class expenseRow (
    date: String,
    business: String,
    spender: String,
    receiver: String,
    transactionType: String,//Purchase/Salary/Donation/Rent/Workshop/Loan
    item: Option[String],
    count: Int,
    amount: Int)

  val expenseTable: List[expenseRow] = List(
    expenseRow("2017-08-31", "reji", "binu", "crusher","purchase",Some("Sand-265"),1, 8390),
    expenseRow("2017-08-31", "reji", "binu", "crusher","purchase",Some("Mital-265"),1, 8125),
    expenseRow("2017-08-31", "reji", "binu", "crusher","purchase",Some("Karinkall-250"),1,20400 ),
    expenseRow("2017-09-01", "reji", "binu", "jcb","rent",Some("excavation"),1,6400 ),
    expenseRow("2017-09-01", "reji", "binu", "site","purchase",Some("tools"),1,2355 ),

    expenseRow("2017-09-02", "reji", "wilson", "binu","salary",Some("salary"),2,900 ),
    expenseRow("2017-09-02", "reji", "wilson", "joni","salary",Some("salary"),2,900 ),
    expenseRow("2017-09-02", "reji", "wilson", "vinod","salary",Some("salary"),2,700 ),
      
    expenseRow("2017-09-02", "sijo", "wilson", "alex","salary",Some("salary"),2,800 ),
    expenseRow("2017-09-02", "sijo", "wilson", "binu","salary",Some("salary"),3,900 ),
    expenseRow("2017-09-02", "sijo", "wilson", "joni","salary",Some("salary"),3,900 ),
    expenseRow("2017-09-02", "sijo", "wilson", "wilson","salary",Some("salary"),4,900 ),
    expenseRow("2017-09-02", "sijo", "wilson", "vinod","salary",Some("salary"),3,700 ),
    expenseRow("2017-09-02", "sijo", "wilson", "saji","salary",Some("salary"),1,700 ),
    expenseRow("2017-09-02", "sijo", "binu", "anish","salary",Some("salary"),3,700 ),
      
    expenseRow("2017-09-02", "roshan", "wilson", "alex","salary",Some("salary"),4,800 ),
    expenseRow("2017-09-02", "roshan", "wilson", "binu","salary",Some("salary"),1,900 ),
    expenseRow("2017-09-02", "roshan", "wilson", "joni","salary",Some("salary"),1,900 ),
    expenseRow("2017-09-02", "roshan", "wilson", "wilson","salary",Some("salary"),2,900 ),
    expenseRow("2017-09-02", "roshan", "wilson", "vinod","salary",Some("salary"),1,700 ),
    expenseRow("2017-09-02", "roshan", "wilson", "saji","salary",Some("salary"),4,700 ),

    expenseRow("2017-09-02", "roshan", "wilson", "ajin","salary",Some("salary"),4,700 ),

    expenseRow("2017-09-13", "roshan", "wilson", "bhai","salary",Some("vaarkka"),3,700 )
  )

  def findExpense(table: List[expenseRow]):Int = {
    table.foldLeft(0){
      case (result,expenseRow(_,_,_,_,_,_,count,amount)) => {
        result + (count * amount)
      }
    }
  }
  def findMapSpenderVsMoney(table: List[expenseRow]):Map[String,List[Int]] = {
    table.foldLeft(Map[String,List[Int]]()){
      case (result,expenseRow(_,_,person,_,_,_,count,amount)) => {
        val amountList = result.getOrElse(person,List())
        result + (person -> (amountList :+ (count*amount)))
      }
    }
  }

  def findMapBusinessVsMoney(table: List[expenseRow]):Map[String,List[Int]] = {
    table.foldLeft(Map[String,List[Int]]()){
      case (result,row) =>
        val amountList = result.getOrElse(row.business,List())
        result + (row.business -> (amountList :+ (row.count*row.amount)))
    }
  }

  def findMapReceiverVsMoney(table: List[expenseRow]): Map[String,List[Int]] = {
    table.foldLeft(Map[String,List[Int]]()){
      case (result,row) =>
        val amountList = result.getOrElse(row.receiver,List())
        result + (row.receiver -> (amountList :+ (row.amount*row.count)))
    }
  }

 //Find Company Expense for last 30 days
 val expense13days = findExpense(table = expenseTable.filter{x => (DateTime.parse(x.date) isAfter DateTime.now.minusDays(30))})

  //Find Map Spender vs money spend
  val moneySpendByWilson = findMapSpenderVsMoney(table = expenseTable).getOrElse("wilson",List()).sum
  val moneySpendByBinu = findMapSpenderVsMoney(table = expenseTable).getOrElse("binu",List()).sum
  val moneySpendByJoni: Int = findMapSpenderVsMoney(table = expenseTable).getOrElse("joni",List()).sum

  moneySpendByBinu + moneySpendByWilson + moneySpendByJoni

  // Find Map customer vs money
  val moneySpendForSijo = findMapBusinessVsMoney(table = expenseTable).getOrElse("sijo",List()).sum
  val moneySpendForRoshan = findMapBusinessVsMoney(table = expenseTable).getOrElse("roshan",List()).sum
  val moneySpendForReji = findMapBusinessVsMoney(table = expenseTable).getOrElse("reji",List()).sum

  //Find Map customer vs money for last 15 days
  val moneySpendForSijoLast13days = findMapBusinessVsMoney(table = expenseTable.filter{x => (DateTime.parse(x.date) isAfter DateTime.now.minusDays(13))}).getOrElse("sijo",List()).sum
  val moneySpendForRoshanLast13days = findMapBusinessVsMoney(table = expenseTable.filter{x => (DateTime.parse(x.date) isAfter DateTime.now.minusDays(13))}).getOrElse("roshan",List()).sum
  val moneySpendForRejiLast13days = findMapBusinessVsMoney(table = expenseTable.filter{x => (DateTime.parse(x.date) isAfter DateTime.now.minusDays(13))}).getOrElse("reji",List()).sum

  moneySpendForSijo + moneySpendForReji + moneySpendForRoshan

  //Find Map Receiver vs money
  val moneyReceivedByCrusher = findMapReceiverVsMoney(table = expenseTable).getOrElse("crusher",List()).sum
  val moneyReceivedByJcb = findMapReceiverVsMoney(table = expenseTable).getOrElse("jcb",List()).sum

  val moneyReceivedByAlex = findMapReceiverVsMoney(table = expenseTable).getOrElse("alex",List()).sum
  val moneyReceivedByBinu = findMapReceiverVsMoney(table = expenseTable).getOrElse("binu",List()).sum
  val moneyReceivedByJoni = findMapReceiverVsMoney(table = expenseTable).getOrElse("joni",List()).sum
  val moneyReceivedByWilson = findMapReceiverVsMoney(table = expenseTable).getOrElse("wilson",List()).sum

  val moneyReceivedByAjin = findMapReceiverVsMoney(table = expenseTable).getOrElse("ajin",List()).sum
  val moneyReceivedByVinod = findMapReceiverVsMoney(table = expenseTable).getOrElse("vinod",List()).sum
  val moneyReceivedBySaji = findMapReceiverVsMoney(table = expenseTable).getOrElse("saji",List()).sum
  val moneyReceivedByAnish = findMapReceiverVsMoney(table = expenseTable).getOrElse("anish",List()).sum

  val moneyReceivedByBhai = findMapReceiverVsMoney(table = expenseTable).getOrElse("bhai",List()).sum
  val moneyReceivedBySite = findMapReceiverVsMoney(table = expenseTable).getOrElse("site",List()).sum

  moneyReceivedByCrusher + moneyReceivedByJcb + moneyReceivedByAlex + moneyReceivedByBinu + moneyReceivedByJoni + moneyReceivedByWilson +
                            moneyReceivedByAjin + moneyReceivedByVinod + moneyReceivedBySaji + moneyReceivedByAnish +
                            moneyReceivedByBhai + moneyReceivedBySite
}



