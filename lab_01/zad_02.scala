object Main extends App {
  print("Podaj dowolną liczbę całkowitą: ")
  val liczba=io.StdIn.readInt()
  if(liczba%2==0){
    println("Podana liczba jest parzysta.")
  }
  else{
    println("Podana liczba jest nieparzysta.")
  }
}