object patternMatch extends App {
  println("Hello Welcome to patternMatch")

  //The Store sells Item
  //An Item could be an Article
  //An Item could be a bunldle of Articles
  abstract class Item
  case class Article(description: String,price: Double) extends Item
  case class Bundle(description: String, discount: Double,items: Item*) extends Item

  def price(it: Item): Double  = {
    it match {
      case Article(_, p) => p
      case Bundle(_, disc, its @ _*) => its.map(price).sum - disc
    }

  }

  val book = Article("Scala For The Imatiant", 39.95)
  val whiskey = Article("Old Potrero",79.95)

  val x = Bundle("For Sera",10.0,book,whiskey)

  println(price(book))
  println(price(x))

}