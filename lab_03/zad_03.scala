object Main extends App {
  print("Podaj dowolne słowo: ")
  var str:String=io.StdIn.readLine()
  def policz(str:String):Int={
    def policz2(str:String,i:Int,k:Int):Int={
      if(i>str.length-1){
        k
      }
      else{
        if(str(i)>=97 && str(i)<=122){
          policz2(str,i+1,k+1)
        }
        else{
          policz2(str,i+1,k)
        }
      }
    }
    policz2(str,0,0)
  }
  println(policz(str))
}