object Main extends App {
  print("Podaj dowolną liczbę całkowitą: ")
  var liczba=io.StdIn.readInt()
  var reszta=2
  var flaga=1
  if(liczba<2){
    print("Podana liczba nie jest pierwsza.")
  }
  else{
      while(reszta<liczba){
        if(liczba%reszta==0){
          flaga=0
        }
        reszta=reszta+1
      }
      if(flaga==1){
        print("Podana liczba jest pierwsza.")
      }
      else{
        print("Podana liczba nie jest pierwsza.")
      }
  }
}