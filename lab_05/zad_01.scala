object Main extends App {
  def isOrdered[A](seq: Seq[A])(leq: (A, A) => Boolean): Boolean = {
    (seq)match {
      case (Seq()) => true
      case (x +: Seq()) => true
      case (x +: y +: seq) => {
        if (leq(x,y)) isOrdered(seq)(leq)
        else false
      }
    }
  }
  val seq = Seq(1,2,3,4,5,6)
  val leq = (x: Int, y: Int) => x < y
  println(isOrdered(seq)(leq))
}