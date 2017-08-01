object partition {

  //partition is the best way for Seperating a Collection based on a condition
  //partition makes a Pair of collections
  "Wilson K Sam".partition(_.isSpaceChar)
  "Wilson K Sam".partition(_.isControl)
  "Wilson K Sam".partition(_.isDigit)
  "Wilson K Sam".partition(_.isLetter)
  "Wilson K Sam".partition(_.isLetterOrDigit)
  "Wilson K Sam".partition(_.isLower)
  "Wilson K Sam".partition(_.isUpper)
  "Wilson K Sam".partition(_.isSurrogate)
  "Wilson K Sam".partition(_.isWhitespace)
  "Wilson K Sam".partition(_.isSpaceChar)
  "malayalam".partition(_.isMirrored)
  "I am not mirrored".partition(_.isMirrored)


  //Partition an integer array as negetive and positive numbers
  var (negList,posList) = Array(1,2,-3,4,-9,0,-4,5,2).partition(_ < 0)
  for(entry <- negList) println(entry)
  for(entry <- posList) println(entry)

}
