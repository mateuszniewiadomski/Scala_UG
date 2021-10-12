import scala.io.Source
object Main extends App {
  val plik: Seq[String] = Source.fromFile("ogniem_i_mieczem.txt").getLines.toList
  def histogram(max: Int): Unit = {
    println(plik.flatMap(a => a.toLowerCase).partition(a => a.isLetter)._1.groupBy(identity).map(a =>
      if(a._2.size > max) (a._1, "*" * max) 
      else (a._1, "*" * a._2.size)).foreach(println))
  }
  val max = 80
  histogram(max)  
}