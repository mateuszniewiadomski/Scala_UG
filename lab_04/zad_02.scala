object Main extends App {
  type Pred[A] = A => Boolean
  var a: Pred[Int] = (n) => n > 2
  var b: Pred[Int] = (n) => n % 2 == 0
  def and[A](p: Pred[A], q: Pred[A]): Pred[A] = (x: A) => p(x) && q(x)
  def or[A](p: Pred[A], q: Pred[A]): Pred[A] = (x: A) => p(x) || q(x)
  def not[A](p: Pred[A]): Pred[A] = (x: A) => !p(x)
  def imp[A](p: Pred[A], q: Pred[A]): Pred[A] = (x: A) => !p(x) || q(x)
  println(and(a,b)(5))
  println(or(a,b)(5))
  println(not(a)(5))
  println(not(b)(5))
  println(imp(a,b)(5))
}