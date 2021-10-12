import scala.io.Source

object Main4 extends App {
    val plik: Seq[String] = Source.fromFile("cyfry.txt").getLines.toList
    val jeden = plik.foldLeft(Seq.empty[Seq[Int]])((acc: Seq[Seq[Int]], curr: String) => acc :+ curr.toSeq.map(n => n.asDigit))
    val czy = jeden.filter(n => n.foldLeft((true, n.head-1))((res: (Boolean, Int), curr: Int) => res match {
        case (false, prev) => (false, curr)
        case (isOrdered, prev) if (prev < curr) => (true, curr)
        case (isOrdered, prev) => (false, curr)
    })._1).size
    println(czy)
}