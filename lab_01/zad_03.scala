object Main extends App {
  var x=1.0
  var y=0.0
  while(x!=0){
    print("Podaj dowolną liczbę: ")
    x=io.StdIn.readDouble()
    y=y+x
  }
  print("y = ")
  print(y)
}