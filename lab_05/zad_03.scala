object Main extends App {
  def deStutter[A](seq: Seq[A])(eq: (A,A) => Boolean)(a: Seq[A]): Seq[A] = (seq) match {
    case (Seq()) => a.reverse
    case (x +: Seq()) => (x +: a).reverse
    case (x +: y +: seq) if (eq(x,y)) => deStutter(y +: seq)(eq)(a)
    case (x +: y +: seq) if (!eq(x,y)) => deStutter(y +: seq)(eq)(x +: a) 
  }
  var seq = Seq(1,1,2,4,4,4,1,3)
  var eq = (x: Int, y: Int) => x == y
  println(deStutter(seq)(eq)(Seq.empty))
}