object Main extends App {
  def position[A](seq: Seq[A], el: A): Option[Int] = {
    seq.zipWithIndex.filter(a => a._1 == el).map(a => a._2).headOption
  }
  var seq = Seq(2, 1, 1, 5)
  var el = 1 
  println(position(seq,el))
  el = 7
  println(position(seq,el))
}