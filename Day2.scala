object Day2 extends App {
  import scala.io.Source
  val input = Source.fromFile("Input/Day2.txt")
  val lines = try input.mkString finally input.close()
  val passes = lines.split("\n")

  //this method returns the product of the two entries that sum to 2020
  def part1(arr:Array[String]):Int = {
    var valid:Int = 0
    //loop through each line
    for (i <- 0 to arr.length-1) {
      var line = arr(i)
      var range = line.substring(0,line.indexOf(" "))
      var min = range.split("-")(0).toInt
      var max = range.split("-")(1).toInt
      var letter = line.substring(line.indexOf(" ")+1,line.indexOf(":"))
      var password = line.substring(line.indexOf(" ",line.indexOf(" ")+1))
      var count = password.count(_.toString == letter)

      if (count <= max && count >= min) {
        valid+=1
      }
    }
    valid
  }

  println(part1(passes))
  //returns 447
}
