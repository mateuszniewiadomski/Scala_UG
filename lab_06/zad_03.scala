object Main extends App {
  def divide[A](seq: Seq[A]): (Seq[A], Seq[A]) = {
    def divide2[A](seq: Seq[A], seq1: Seq[A], seq2: Seq[A], l: Int): (Seq[A], Seq[A]) = {
      (seq) match {
        case (Seq()) => (seq1, seq2)
        case (a +: Seq()) if (l == 1) => divide2(Seq(), seq1 :+ a, seq2, l-1)
        case (a +: Seq()) if (l == 0) => divide2(Seq(), seq1, seq2 :+ a, l+1)
        case (a +: seq) if (l == 1) => divide2(seq, seq1 :+ a, seq2, l-1)
        case (a +: seq) if (l == 0) => divide2(seq, seq1, seq2 :+ a, l+1)
      }
    }

    divide2(seq, Seq(), Seq(), 1)
  }
  var seq = Seq(1,3,5,6,7)
  println(divide(seq))
}