object Main extends App {
  print("Podaj dane do tablicy: ")
  var dane:String=io.StdIn.readLine()
  var tab:Array[Int]=new Array[Int](dane.length)
  var i:Int=0
  while(i<dane.length){
    tab(i)=dane(i)
    i=i+1
  }
  def palindrom(tab:Array[Int]):Boolean={
    var x:Int=0
    var y:Int=tab.size-1
    def palindrom2(tab:Array[Int],x:Int,y:Int):Boolean={
      if(x>y-x){
        true
      }
      else if(tab(x)!=tab(y-x)){
        false
      }
      else{
        palindrom2(tab,x+1,y)
      }
    }
    palindrom2(tab,x,y)
  }
  print(palindrom(tab))
}