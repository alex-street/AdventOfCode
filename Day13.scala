object Day1 extends App {
  import scala.io.Source
  val input = Source.fromFile("Input/Day13.txt")
  val lines = try input.mkString finally input.close()
  val nums = lines.split("\n")

  val departTime = nums(0).toInt
  val busList = nums(1)
  val busIDs = busList.split(",")

  def find(time:Long):Long = {
    var next = false
    for (i <- 0 to busIDs.length-1) {
      if (busIDs(i) == "x") {
      }
      else {
        if ((time+i)%busIDs(i).toInt==0) {
        }
        else {
          next = true
        }
      }
      if (next) {
        0L
      }
      else {
        time
      }
    }
  }


  //returns the product of the two entries that sum to 2020
  def part2():Long = {
    for ( t <- 100000000000000L to 10000000000000000L) {
      if (find(t)!=0) {
        find(t)
      }
    }
  }


  println(part2())
  //returns
}
