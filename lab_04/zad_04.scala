object Main extends App {
  type MSeq[A] = A => String
  def size[A](a: Seq[A]): Int = (a) match {
    case _ if (a.isEmpty) => 0
    case (x +: a) => 1 + size(a)
  }
  println(size("SCALA"))
  def size2[A](a: Seq[A])(b: Int): Int = (a) match {
    case _ if (a.isEmpty) => b
    case (x +: a) => size2(a)(b+1)
  }
  println(size2("SCALA")(0))
}