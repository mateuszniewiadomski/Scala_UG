object Main extends App {
  def applyForAll2[A,B,C](seq1: Seq[A], seq2: Seq[B], f: (A, B) => C): Seq[C] = { 
    def helper(a: Seq[A], b: Seq[B], seq: Seq[C]): Seq[C] = (a, b) match { 
      case _ if a.isEmpty || b.isEmpty => seq 
      case (a1+:atail, b1+:btail) => helper(atail, btail, seq :+ f(a1, b1)) 
      }  
    helper(seq1, seq2, Seq()) 
  } 
  var seq1_1 = Seq(1,3,5)
  var seq1_2 = Seq(1,3,5,6,7)
  var seq2 = Seq(2,3,4)
  println(applyForAll2(seq1_1,seq2, (n:Int, m:Int) => (n>m)).mkString("[", ", ", "]")) 
  println(applyForAll2(seq1_2,seq2, (n:Int, m:Int) => (n>m)).mkString("[", ", ", "]")) 
}