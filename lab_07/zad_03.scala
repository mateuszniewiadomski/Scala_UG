object Main extends App {
  def deStutter[A](seq: Seq[A]): Seq[A] = {
      seq.foldLeft[Seq[A]](Seq()) {
        (n,m) => (n,m) match {
          case (Seq(), _) => n :+ m
          case (seq :+ a, _) if (a != m) => n :+ m
          case _ => n
        }
      }
  }
  val seq = Seq(1, 1, 2, 4, 4, 4, 1, 3)
  println(deStutter(seq))
}
