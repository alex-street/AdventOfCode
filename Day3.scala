object Day3 extends App {
  import scala.io.Source
  val input = Source.fromFile("Input/Day3.txt")
  val lines = try input.mkString finally input.close()
  val slopes = lines.split("\n")

  //counts how many trees you would encounter with slope of (+3,-1)
  def part1(arr:Array[String]):Int = {
    var trees:Int = 0
    //repeat rest of line
    for (i <- 0 to arr.length-1) {
      var x = (3*i)%arr(i).length
      var space = arr(i)(x)
      if (space.toString =="#") {
        trees+=1
      }
    }
    trees
  }

  //returns product of the number of trees encountered on each of the listed slopes
  def part2(arr:Array[String]):Int = {
    var trees1:Int = 0
    var trees2:Int = 0
    var trees3:Int = 0
    var trees4:Int = 0
    var trees5:Int = 0
    //repeat rest of line
    for (i <- 0 to arr.length-1) {
      if (arr(i)(i%arr(i).length).toString =="#") {
        trees1+=1
      }
      if (arr(i)((3*i)%arr(i).length).toString =="#") {
        trees2+=1
      }
      if (arr(i)((5*i)%arr(i).length).toString =="#") {
        trees3+=1
      }
      if (arr(i)((7*i)%arr(i).length).toString =="#") {
        trees4+=1
      }
      if (i%2 == 0 && arr(i)((i/2)%arr(i).length).toString =="#") {
        trees5+=1
      }
    }
    trees1*trees2*trees3*trees4*trees5
  }

  println(part1(slopes))
  //returns 193
  println(part2(slopes))
  //returns 1355323200
}
