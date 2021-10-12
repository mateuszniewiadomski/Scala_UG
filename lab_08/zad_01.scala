object Main extends App {
  def sum(seq: Seq[Option[Double]]): Double = {
    seq.foldLeft(0.0) {
      (a,b) => (b) match {
        case Some(a1) => a1 + a 
        case None => a
      }
    }
  }
  var seq = Seq(Some(5.4), Some(-2.0), Some(1.0), None, Some(2.6))
  println(sum(seq))
}