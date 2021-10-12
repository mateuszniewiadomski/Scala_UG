object Main extends App {
  print("Podaj ile wyrazów chcesz podać: ")
  var n=io.StdIn.readInt()
  println("Podaj "+(n)+" wyrazów: ")
  var slowo=new Array[String](n)
  var i=0
  while(i<n){
    print("  -  Podaj "+(i+1)+" słowo: ")
    slowo(i)=io.StdIn.readLine()
    i=i+1
  }
  i=0
  var j=0
  var y=""
  while(i<n){
    j=0
    while(j<n-1){
      if(slowo(j).length>slowo(j+1).length){
          y=slowo(j)
          slowo(j)=slowo(j+1)
          slowo(j+1)=y
        }
        else if(slowo(j).length==slowo(j+1).length){
          if(slowo(j)>slowo(j+1)){
          y=slowo(j)
          slowo(j)=slowo(j+1)
          slowo(j+1)=y
          }
        }
      j=j+1
    }
    i=i+1
  }
  i=0
  while(i<n){
    println((i+1)+". "+(slowo(i)))
    i=i+1
  }
  
}