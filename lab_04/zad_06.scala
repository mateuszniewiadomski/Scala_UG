object Main extends App {
  def merge[A](a: Seq[A], b: Seq[A])(leq: (A, A) => Boolean)(c: Seq[A]): Seq[A] = (a,b) match {
    case (Seq(),Seq()) => c.reverse
    case (Seq(), y +: b) => merge(Seq(),b)(leq)(y +: c)
    case (x +: a, Seq()) => merge(a,Seq())(leq)(x +: c)
    case (x +: a, y +: b) if (leq(x,y)) => merge(a,y +: b)(leq)(x +: c)
    case (x +: a, y +: b) if (!leq(x,y)) => merge(x +: a,b)(leq)(y +: c)
  }
  var a = Seq(1,3,5,8)
  var b = Seq(2,4,6,8,10,12)
  var leq = (m: Int, n: Int) => m < n
  println(a)
  println(b)
  println(merge(a,b)(leq)(Seq.empty)) 
}