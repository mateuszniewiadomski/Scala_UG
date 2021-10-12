object Main extends App {
  def forall[A](a: Seq[A])(pred: (A) => Boolean): Boolean = (a) match {
    case (Seq()) => true
    case (x +: a) if (pred(x)) => forall(a)(pred)
    case _ => false
  }
  var a = Seq(1,3,5,7)
  var b = Seq(1,3,6,7)
  var pred = (n: Int) => n % 2 != 0
  println(forall(a)(pred))
  println(forall(b)(pred))
}