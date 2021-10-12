object Main extends App {
  def compute[A,B](seq: Seq[A])(init: B)(op: (A, B) => B): B = (seq) match {
    case (Seq()) => init
    case (a +: Seq()) => compute(Seq())(op(a,init))(op)
    case (a +: seq) => compute(seq)(op(a,init))(op)
  }
  println(compute(Seq(1,2,3,4))(0)(_ + _))
  println(compute(Seq(1,2,3,4))(1)(_ * _))
  println(compute(Seq("kota"," ","ma"," ","ala"))("")(_ + _))
  
}