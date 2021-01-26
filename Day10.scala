object Day1 extends App {
  import scala.io.Source
  val input = Source.fromFile("Input/Day1.txt")
  val lines = try input.mkString finally input.close()
  val nums = lines.split("\n").map(n => n.toInt)

  var diff1 = 0
  var diff3 = 1
  //
  def part1(arr:Array[Int], index:Int):Int = {
    var answer:Int = 0
    for (i <- 0 to arr.length-1) {

    }
    answer
  }

  def part2(arr:Array[Int]):Int = {

  }

  println(part1(nums))
  //returns
}
