object Main extends App {
  val secret = Seq(1, 3, 2, 2, 4, 5)
  val guess = Seq(2, 1, 2, 4, 7, 2)
  /* czarne dobry kolor w dobrym miejscu */
  val black = secret.zip(guess).count(para => para._1 == para._2)
  /* biale dobry kolor w zlym miejscu */
  val white = secret.intersect(guess).size - black
  println(s"Black = $black")
  println(s"White = $white")
}