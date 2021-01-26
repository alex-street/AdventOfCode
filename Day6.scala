object Day1 extends App {
  import scala.io.Source
  val input = Source.fromFile("Input/Day6.txt")
  val lines = try input.mkString finally input.close()
  val groups = lines.split("\n\n")

  //return of anyone who answers yes
  def part1(arr:Array[String]):Int = {
    var sum:Int = 0
    for (i <- 0 to arr.length-1) {
      var exists = ""
      var people = arr(i).split("\n")
        for (person <- people) {
          for (char <- person) {
            if (!exists.contains(char)) {
              exists += char
            }
          }
        }
      sum+=exists.length
    }
    sum
  }

  //return of everyone who answers yes
  def part2(arr:Array[String]):Int = {
    var sum:Int = 0
    val alphabet = "abcdefghijklmnopqrstuvwxyz"
    for (i <- 0 to arr.length-1) {
      var count = 0
      var people = arr(i).split("\n")
      var len = people.length
      for (letter <- alphabet) {
        var yes = 0
        for (person <- people) {
          if (person.contains(letter)) {
            yes+=1
          }
        }
        if (yes == len) {
          count+=1
        }
      }
      sum+=count
    }
    sum
  }

  println(part1(groups))
  //returns 6504
  println(part2(groups))
  //returns 3351

}
