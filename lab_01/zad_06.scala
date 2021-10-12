object Main extends App {
  var liczba=0
  do{
    print("Podaj dowolną liczbę parzystą większą od 2: ")
    liczba=io.StdIn.readInt()
  }while(liczba<=2||liczba%2!=0)
  var x1=2
  var x2=2
  var y1=2
  var y2=2
  var flagax=1
  var flagay=1
  var o1=2
  var o2=2
  while(o1+o2!=liczba){
    println(o1)
    println(o2)
    flagay=1
    y1=y1+1
    y2=2
    if(y1>=liczba){
      flagax=1
      x1=x1+1
      x2=2
      y1=2
      while(x2<x1){
        if(x1%x2==0){
          flagax=0
        }
        x2=x2+1
      }
      if(flagax==1){
        o1=x1
      }
    }
    while(y2<y1){
        if(y1%y2==0){
          flagay=0
        }
        y2=y2+1
      }
      if(flagay==1){
        o2=y1
      } 
  }
  print(o1)
  print(" + ")
  print(o2)
  print(" = ")
  print(liczba)}