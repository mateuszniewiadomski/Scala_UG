object Main extends App {
  def freq[A](seq: Seq[A]): Map[A, Int] = {
    seq.groupBy(a => a).map(a => (a._1,a._2.size))
  }
  var seq = Seq('a','b','a','c','c','a')
  println(freq(seq))
}