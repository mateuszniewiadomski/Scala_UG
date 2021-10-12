object Main extends App {
  print("Podaj n: ")
  var n:Int=io.StdIn.readInt
  def ciag(n:Int):Int={
    def f(n:Int):Int={
      if(n==0){
        1
      }
      else if(n==1){
        1
      }
      else{
        f(n-1)+f(n-2)
      }
    }
    f(n)
  }
  print(ciag(n))
}