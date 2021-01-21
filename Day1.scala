object Day1 extends App {
  import scala.io.Source
  val input = Source.fromFile("Input/Day1.txt")
  val lines = try input.mkString finally input.close()
  val nums = lines.split("\n").map(n => n.toInt)

  //this method returns the product of the two entries that sum to 2020
  def part1(arr:Array[Int]):Int = {
    var answer:Int = 0
    for (i <- 0 to arr.length-1) {
      for (k <- 0 to arr.length-1) {
        if (arr(i)+arr(k)==2020) {
          answer = arr(i)*arr(k)
        }
      }
    }
    answer
  }

  def part2(arr:Array[Int]):Int = {
    var answer:Int = 0
    for (i <- 0 to arr.length-1) {
      for (k <- 0 to arr.length-1) {
        for (j <- 0 to arr.length-1) {
          if (arr(i)+arr(k)+arr(j)==2020) {
          answer = arr(i)*arr(k)*arr(j)
          }
        }
      }
    }
    answer
  }

  println(part1(nums))
  //returns 786811
  println(part2(nums))
  //returns 199068980
}
