object classExcercise {

class Time(val hours:Int=0,val minutes:Int=0) {
  //write down here the Constructor conditions if any like crazy inputs
  if(hours < 0 || hours >= 24 || minutes < 0 ||minutes >= 60) throw new IllegalArgumentException

  def -(other: Time) = (this.hours*60+this.minutes) - (other.hours*60+other.minutes)
  def <(other: Time) = this before other
  //Methods supported by the object
  def before(other: Time) = (hours < other.hours) || (hours == other.hours && minutes < other.minutes)
  //How the object is displayed
  override def toString: String = f"${hours}%02d:${minutes}%02d"
}

  object Time  {
    def apply(hours:Int,minutes:Int) = new Time(hours,minutes)
  }

  val morning = new Time(6,0)
  val evening = new Time(16,0)

  morning before evening
  evening before morning

  val daystart = new Time()
  daystart before morning
  morning before daystart

  morning < evening
  evening < evening
  daystart < evening
  evening < daystart

  Time(0,0) - Time(23,59)
  Time(23,58) - Time(23,59)
  Time(23,59) - Time(23,59)
  Time(23,59) - Time(0,59)

  Time(3,59) < Time(23,59)
  Time(2,59) < Time(0,59)
  Time(3,59) < Time(4,0)

//  val crazyTime = new Time(-1,59)
//  val crazyTime1 = new Time(24,59)
//  val crazyTime2 = new Time(2,60)
//  val crazyTime3 = new Time(25,59)
}