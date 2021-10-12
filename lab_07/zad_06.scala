object Main extends App {
  def countChars(str: String): Int = {
    str.groupBy(a => a).map(a => a._1).size
  }
  var str = "Ser przełożyć do miski, dodać cukier, mąkę ziemniaczaną, cukier wanilinowy i jajka. Zmiksować do połączenia się składników, następnie dodać śmietankę i miksować jeszcze przez ok. 2 minuty."
  println(countChars(str))
  println(str.groupBy(a => a).map(a => a._1))
}