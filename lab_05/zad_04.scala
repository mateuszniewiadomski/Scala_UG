object Main extends App {
  def compress[A](seq: Seq[A])(eq: (A,A) => Boolean)(sum: Int)(a: Seq[(A,Int)]): Seq[(A,Int)] = (seq) match {
    case (Seq()) => a.reverse
    case (x +: Seq()) => ((x,sum) +: a).reverse
    case (x +: y +: seq) if (eq(x,y)) => compress(y +: seq)(eq)(sum+1)(a)
    case (x +: y +: seq) if (!eq(x,y)) => compress(y +: seq)(eq)(1)((x,sum) +: a)
  }
  var seq = Seq('a', 'a', 'b', 'c', 'c', 'c', 'a', 'a', 'b', 'd')
  var eq = (x: Char, y: Char) => x == y
  println(compress(seq)(eq)(1)(Seq()))
}