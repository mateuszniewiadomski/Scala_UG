object Main extends App {
  def remElems[A](seq: Seq[A], k: Int): Seq[A] = {
    seq.zipWithIndex.filter(a => a._2!=k-1).map(a => a._1)
  }
  var seq = Seq(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20)
  var k = 4
  println(remElems(seq,k))
}