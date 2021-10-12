object Main extends App {
  print("Podaj tekst do zaszyfrowania (WIELKIMI LITERAMI): ")
  var slowo:String=io.StdIn.readLine()
  print("Podaj klucz (WIELKIMI LITERAMI): ")
  var klucz:String=io.StdIn.readLine()
  var i:Int=0
  var j:Int=0
  var a:Int=0
  while(i<slowo.length){
    if(slowo(i)>=65 && slowo(i)<=90){
      j=j+1
    }
    i=i+1
  }
  var ciagslowo:Array[Char]=new Array[Char](j)
  var ciagklucz:Array[Char]=new Array[Char](j)
  var szyfr:Array[Char]=new Array[Char](j)
  i=0
  j=0
  while(i<slowo.length){
    if(slowo(i)>=65 && slowo(i)<=90){
      ciagslowo(j)=slowo(i)
      j=j+1
    }
    i=i+1
  }
  i=0
  while(i<j){
    ciagklucz(i)=klucz(i%klucz.length)
    i=i+1
  }
  i=0
  while(i<j){
    if((ciagklucz(i)+ciagslowo(i)-65)>90){
      a=ciagklucz(i)+ciagslowo(i)-91
      szyfr(i)=a.toChar
    }
    else{
      a=ciagklucz(i)+ciagslowo(i)-65
      szyfr(i)=a.toChar
    }
    i=i+1
  }
  i=0
  while(i<j){
    print(szyfr(i))
    i=i+1
  }
}