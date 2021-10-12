object Main extends App {
  def europa(seq: Seq[String]): Seq[String] = {
    seq.filter(_.contains("Europe")).map(a => a.stripPrefix("Europe/")).sortBy(s => s.length)
  }
  val strefy: Seq[String] = java.util.TimeZone.getAvailableIDs.toSeq
  println(europa(strefy))
}