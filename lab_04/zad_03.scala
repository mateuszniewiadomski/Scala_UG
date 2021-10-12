object Main extends App {
  type MSet[A] = A => Int
  var a: MSet[Int] = (n: Int) => (n) match {
    case 1 => 2
    case 3 => 1
    case _ => 0
  }
  var b: MSet[Int] = (n: Int) => (n) match {
    case 1 => 2
    case 2 => 3
    case 4 => 1
    case _ => 0
  }
  def +[A](s1: MSet[A], s2: MSet[A]): MSet[A] = (x: A) => s1(x) + s2(x)
  println("Suma:")
  println(+[Int](a,b)(1))
  println(+[Int](a,b)(2))
  println(+[Int](a,b)(3))    
  println(+[Int](a,b)(4))
  println(+[Int](a,b)(5))
  def -[A](s1: MSet[A], s2: MSet[A]): MSet[A] = (x: A) => s1(x) - s2(x)
  println("Różnica:")
  println(-[Int](a,b)(1))
  println(-[Int](a,b)(2))
  println(-[Int](a,b)(3))    
  println(-[Int](a,b)(4))
  println(-[Int](a,b)(5))
  def &[A](s1: MSet[A], s2: MSet[A]): MSet[A] = (x: A) => s1(x) min s2(x)
  println("Część wspólna:")
  println(&[Int](a,b)(1))
  println(&[Int](a,b)(2))
  println(&[Int](a,b)(3))    
  println(&[Int](a,b)(4))
  println(&[Int](a,b)(5))
}