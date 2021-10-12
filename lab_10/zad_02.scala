import scala.io.Source

object Main extends App {
  val plik: Seq[String] = Source.fromFile("osoby.txt").getLines.toList
  val seq = Seq("Jan Kowalski","Andrzej Nowak","Anna Kowalek")
  val przyklad = seq.groupBy(a => a.size-1).mapValues(a => a.size)
  println(s"przyklad: $przyklad")
  val odwzorowanie = plik.groupBy(a => a.size-1).mapValues(a => a.size)
  println(s"odwzorowanie: $odwzorowanie")
}