object Day1 extends App {
  import scala.io.Source
  val input = Source.fromFile("Input/Day5.txt")
  val lines = try input.mkString finally input.close()
  val passes = lines.split("\n")

//returns the the highest seat ID on a boarding pass
  def part1(arr:Array[String]):Int = {
    var answer:Int = 0
    var id = 0
    var ids:Array[Int] = Array()
    for (i <- 0 to arr.length-1) {
      var max = 127.0
      var min = 0.0
      var range = max-min
      var maxC = 7.0
      var minC = 0.0
      var rangeC = maxC-minC
      var col = 0.0
      var number = 0.0
      for (k <- 0 to arr(i).length-1) {
        val letter = arr(i)(k)
        if (letter=='F') {
           max = (max-0.5*range).floor
           range = max-min
         }
         else if (letter=='B') {
           min = (min+0.5*range).ceil
           range = max-min
         }
         else if (letter=='R') {
           minC = (0.5*rangeC+minC).ceil
           rangeC = maxC-minC
         }
         else if (letter=='L') {
           maxC = (maxC-0.5*rangeC).floor
           rangeC = maxC-minC
         }
         if (k ==6) {
           if (letter=='F') {
             number=min
           }
           else if (letter=='B') {
             number=max
           }
         }
         else if (k ==9) {
           if (letter=='L') {
             col=minC
           }
           else if (letter=='R') {
             col=maxC
           }
         }
      }
      id = (number*8 +col).toInt
      ids = ids :+ id
    }
    ids.sorted
    ids(0)
  }

  println(part1(passes))

}
