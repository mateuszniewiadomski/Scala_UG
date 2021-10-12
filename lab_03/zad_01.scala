object Main extends App {
  print("Podaj dowlny ciąg znaków: ")
  var str:String=io.StdIn.readLine()
  print(odwroc(str))
  def odwroc(str:String):String={
    var n:Int=str.length-1
    def odwroc2(str:String,n:Int):String={
      if(n<0){
        ""
      }
      else{
        str(n)+odwroc2(str,n-1)
      }
    }
    odwroc2(str,n)
  }
}
