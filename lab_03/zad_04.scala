object Main extends App {
  print("Podaj dowolna liczbe: ")
  var n:Int=io.StdIn.readInt()
  def pierwsza(n:Int):Boolean={
    def pierwsza2(n:Int,k:Int):Boolean={
      if(k>=n){
        true
      }
      else{
        if(n%k==0){
          false
        }
        else{
          pierwsza2(n,k+1)
        }
      }
    }
    pierwsza2(n,2)
  }
  println(pierwsza(n))
}