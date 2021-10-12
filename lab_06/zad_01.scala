object Main extends App {
  def applyForAll[A,B](seq: Seq[A], f: A => B)(newseq: Seq[B]): Seq[B] = (seq) match {
    case (Seq()) => newseq.reverse
    case (a +: Seq()) => ((f(a)) +: newseq).reverse
    case (a +: seq) => applyForAll(seq,f)((f(a)) +: newseq)
  }
  var seq = Seq(1,3,5)
  var f = (n: Int) => n + 3
  println(applyForAll(seq,f)(Seq()))
}