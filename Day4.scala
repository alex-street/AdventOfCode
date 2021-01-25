object Day4 extends App {
  import scala.io.Source
  val input = Source.fromFile("Input/Day4.txt")
  val lines = try input.mkString finally input.close()
  val passports = lines.split("\n\n")

  //returns number of valid passwords
  def part1(arr:Array[String]):Int = {
    var valid:Int = 0
    for (i <- 0 to arr.length-1) {
      if (arr(i).contains("byr")&&arr(i).contains("iyr")&&arr(i).contains("eyr")&&arr(i).contains("hgt")&&arr(i).contains("hcl")&&arr(i).contains("ecl")&&arr(i).contains("pid")) {
        valid+=1
      }
    }
    valid
  }

  //returns number of valid passwords
  def part2(arr:Array[String]):Int = {
    var valid:Int = 0
    var good = 0
    for (i <- 0 to arr.length-1) {
      val passport = arr(i).split(" |\n")
      for (field <- passport) {
        val key = field.split(":")(0)
        val value = field.split(":")(1)
        if (key == "byr") {
          val year = value.toInt
          if (year >= 1920 && year <= 2002) {
            good+=1
          }
        }
        else if (key == "iyr") {
          val year = value.toInt
          if (year >= 2010 && year <= 2020) {
            good+=1
          }
        }
        else if (key == "eyr") {
          val year = value.toInt
          if (year >= 2020 && year <= 2030) {
            good+=1
          }
        }
        else if (key == "hgt") {
          if (value.contains("cm")) {
            val height = value.substring(0,value.indexOf("cm")).toInt
            if (height >= 150 && height <= 2030) {
              good+=1
            }
          }
          if (value.contains("in")) {
            val height = value.substring(0,value.indexOf("in")).toInt
            if (height >= 150 && height <= 2030) {
              good+=1
            }
          }
        }
        else if (key == "hcl") {
          val color = value
          val characters:Array[Char] = Array('0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f')
          if (color(0).toString == "#" && color.length == 7) {
            var validChars = 0
            for (ch <- color.substring(1)) {
              if (characters.contains(ch)) {
                validChars+=1
              }
            }
            if (validChars == 6) {
              good+=1
            }
          }
        }
        else if (key == "ecl") {
          val ecl = value
          if (ecl=="amb" | ecl=="blu" | ecl=="brn" | ecl=="gry" | ecl=="grn" | ecl=="hzl" | ecl=="oth") {
            good+=1
          }
        }
        else if (key == "pid") {
          val pid = value
          if (pid.length == 9) {
            good+=1
          }
        }
      }
      if (good == 7) {
        valid+=1
                for (field <- passport) println(field)
      }
    }
    valid
  }

  println(part1(passports))
  //returns 192
  println(part2(passports))
  //returns
}
