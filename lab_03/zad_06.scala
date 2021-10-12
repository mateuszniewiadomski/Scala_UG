object Main extends App {
  print("Podaj wysokosc trojkata: ")
  var n:Int=io.StdIn.readInt
  def trojkat(n:Int):Unit={
    def trojkat2(n:Int,i:Int):Unit={
      def trojkat3(n:Int,i:Int,j:Int,k:Int):Unit={
        def newton(n:Int,k:Int,wynik:Int,i:Int):Unit={
          if(i>k){
            print(" "+(wynik))
          }
          else{
            newton(n,k,wynik*(n-i+1)/i,i+1)
          }
        }
        if(k<0){
          trojkat2(n,i-1)
        }
        else if(j>=0){
          print(" ")
          trojkat3(n,i,j-1,k)
        }
        else{
          if(k==0){
            print(" "+(1))
            trojkat3(n,i,j,k-1) 
          }
          else{
            newton(n-i-1,k,1,1)
            trojkat3(n,i,j,k-1)
          }
        }
      }
      if(i<0){
        println()
      }
      else{
        println()
        trojkat3(n,i,i,n-i-1)
      }

    }
    trojkat2(n,n-1)
  }
  trojkat(n)
}
