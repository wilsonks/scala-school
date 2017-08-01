object argumentss {

  //Two Scala feature
  //1. Default Argument Feature
  //2. Named Argument Feature
  //3. Variable Arguments

  //Default Argument feature Allows you to omit argument values
  def decorate(str: String,left: String="[",right:String="]") = left +str + right

  decorate("Wilson","---->")

  //Named Argument feature  gives more clarity to the Arguments
  decorate(str="Wilson",right="---->",left="<----")
  decorate(left="<----",str="Wilson",right="---->")


  //variable Number of arguments indicated with * after type
  def sum(args: Int*) = {
    var res = 0
    for(arg <- args) res += arg
    res
  }

  sum(1,2,3,4,5,6)

  //THIS IS SPECIAL AND TO BE MEMORIZED - How do you pass a Seq as a Variable Argument
  //If you already have a Seq[Int], need a special decoration to pass it.

  //   ": -*" Read as------>Consider this as a sequence of something
  sum(1 to 6 : _*)

  val seq1 = Seq.newBuilder[Int]
  seq1 += (1,2,3,4,5,6,7)
  sum(seq1.result() : _*)

}


