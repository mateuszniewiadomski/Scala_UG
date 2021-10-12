object Main extends App {
  def indices[A](seq: Seq[A], el: A): Set[Int] = {
    seq.zipWithIndex.filter(a => a._1 == el).map(a => a._2).toSet
  }
  var seq = Seq(1, 2, 1, 1, 5)
  var el = 1 
  println(indices(seq,el))
  el = 7
  println(indices(seq,el))
}