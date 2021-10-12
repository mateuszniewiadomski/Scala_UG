object Main extends App {
  def pairPosNeg(seq: Seq[Double]): (Seq[Double], Seq[Double]) = {
    seq.filter(_ != 0).partition(_ > 0.0)
  }
  var seq = Seq(1.0,2.0,-3.0,-4.0,5.0,-6.0,-7.0,8.0,9.0,-10.0,-11.0,12.0,-13.0,14.0)
  println(pairPosNeg(seq))
}