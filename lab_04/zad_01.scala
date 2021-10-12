object Main extends App {

  def compose[A,B,C](f: A => B)(g: B => C): A => C = {
    x: A => g(f(x))
  }
  def prod[A,B,C,D](f: A => C, g: B => D): (A,B) => (C,D) = {
    (x: A,y: B) => (f(x),g(y))
  } 
  def lift[A,B,T](op: (T,T) => T)(f: A => T,g: B => T): (A,B) => T = {
    (x: A,y: B) => op(f(x),g(y))
  }
}