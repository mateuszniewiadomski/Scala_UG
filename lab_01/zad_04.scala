object Main extends App {
  print("Podaj dowolną liczbę całkowitą: ")
  var liczba1=io.StdIn.readInt()
  print("Podaj dowolną liczbę całkowitą: ")
  var liczba2=io.StdIn.readInt()
  var liczba3=0
  while(liczba2!=0){
    liczba3=liczba1%liczba2
    liczba1=liczba2
    liczba2=liczba3
  }
  print("NWD = ")
  print(liczba1)
}