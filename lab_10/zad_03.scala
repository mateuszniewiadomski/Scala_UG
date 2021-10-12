import scala.io.Source

object Main extends App {
  val nazwa: Seq[String] = Source.fromFile("liczby.txt").getLines.toList
  val seq = Seq(1, 3, 2, 4, 5, 6)
  val przyklad = seq.partition(a => a%2 == 0)
  println(s"przyklad: $przyklad")
  val result = nazwa.map(a => a.toInt).partition(a => a%2 == 0)
  println(s"result = $result")
}