object Main extends App {
  def insertInto[A](a: A, seq: Seq[A])(leq: (A,A) => Boolean)(b: Seq[A]): Seq[A] = (a,seq) match {
    case (a, Seq()) => (a +: b).reverse
    case (a, x +: seq) if (leq(a,x)) => insertInto(x,seq)(leq)(a +: b)
    case (a, x +: seq) if (!leq(a,x)) => insertInto(a,seq)(leq)(x +: b)
  } 
  var a = 5
  var s = Seq(1,2,3,4,6,7,8,9,10)
  var leq = (x: Int, y: Int) => x < y
  var aString = "Krzeslo"
  var sString = Seq("Fotel","Kanapka","Ziemniaki")
  var leqString = (x: String, y: String) => x < y
  println(insertInto(a,s)(leq)(Seq.empty))
  println(insertInto(aString,sString)(leqString)(Seq.empty))
}