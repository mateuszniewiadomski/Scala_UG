object Main extends App {
  def size[A](seq: Seq[A]): Int = {
    def compute[A](seq: Seq[A])(init: Int)(op: (Int, Int) => Int): Int = (seq) match {
      case (Seq()) => init
      case (a +: Seq()) => compute(Seq())(op(1,init))(op)
      case (a +: seq) => compute(seq)(op(1,init))(op)
    }
    compute(seq)(0)(_ + _)
  }
  var seq = Seq(1,2,3,4,5,6,7,8,9)
  println("Przykład A: " + size(seq))
  def reverse[A](seq: Seq[A]): Seq[A] = {
    def compute[A](seq: Seq[A])(init: Seq[A])(op: (A, Seq[A]) => Seq[A]): Seq[A] = (seq) match {
      case (Seq()) => init
      case (a +: Seq()) => compute(Seq())(op(a,init))(op)
      case (a +: seq) => compute(seq)(op(a,init))(op)
    }
  compute(seq)(Seq())(_ +: _)
  }
  println("Przykład B: " + reverse(seq))
  def ApplyForAll[A](seq: Seq[A])(f: A => A): Seq[A] = {
    def compute[A](seq: Seq[A])(f: A => A)(init: Seq[A])(op: (A, Seq[A]) => Seq[A]): Seq[A] = (seq) match {
      case (Seq()) => init.reverse
      case (a +: Seq()) => compute(Seq())(f)(op(f(a),init))(op)
      case (a +: seq) => compute(seq)(f)(op(f(a),init))(op)
    }
    compute(seq)(f)(Seq())(_ +: _)
  }
  var f = (n: Int) => n + 3
  println("Przykład C: " + ApplyForAll(seq)(f))
  def filter[A](seq: Seq[A])(g: A => Boolean): Seq[A] = {
    def compute[A](seq: Seq[A])(g: A => Boolean)(init: Seq[A])(op: (A, Seq[A]) => Seq[A]): Seq[A] = (seq) match {
      case (Seq()) => init.reverse
      case (a +: Seq()) if(g(a)) => compute(Seq())(g)(op(a,init))(op)
      case (a +: seq) if(g(a)) => compute(seq)(g)(op(a,init))(op)
      case (a +: Seq()) if(!g(a)) => compute(Seq())(g)(init)(op)
      case (a +: seq) if(!g(a)) => compute(seq)(g)(init)(op)
    }
    compute(seq)(g)(Seq())(_ +: _)
  }
  var g = (n: Int) => n % 2 == 0
  println("Przykład D: " + filter(seq)(g))
  def forall[A](seq: Seq[A])(y: A => Boolean): Boolean = {
    def compute[A](seq: Seq[A])(y: A => Boolean)(init: Boolean)(op: (Boolean,Boolean) => Boolean): Boolean = (seq) match {
      case (Seq()) => init
      case (a +: Seq()) => compute(Seq())(y)(op(y(a),init))(op)
      case (a +: seq) => compute(seq)(y)(op(y(a),init))(op)
    }
    compute(seq)(y)(true)(_ && _)
  }
  var y = (n: Int) => n > 4
  println("Przykład E: " + forall(seq)(y))
}