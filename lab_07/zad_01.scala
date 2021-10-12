object Main extends App {
  def subseq[A](seq: Seq[A], begIdx: Int, endIdx: Int): Seq[A] = {
    seq.drop(begIdx).take(endIdx-begIdx)
  }
  var seq = Seq(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20)
  var begIdx = 3
  var endIdx = 15
  println(subseq(seq, begIdx, endIdx))
}