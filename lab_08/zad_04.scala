object Main extends App {
  def swap[A](seq: Seq[A]): Seq[A] = {
    seq.grouped(2).flatMap(_.reverse).toList
  }
  var seq = Seq(1, 2, 3, 4, 5)
  println(swap(seq))
}
