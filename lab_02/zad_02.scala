object Main extends App {
  print("Podaj x: ")
  var x=io.StdIn.readLine()
  print("Podaj y: ")
  var y=io.StdIn.readLine()
  var i=x.length-1
  var j=y.length-1
  var g=0
  var a=0
  var b=0
  var c=new Array[Int](1000)
  var flaga=0
  do{
    g=g+1
    if(i<0){
      a=0
    }
    else{
      a=x(i)-48
    }
    if(j<0){
      b=0
    }
    else{
      b=y(j)-48
    }
    if(flaga==1){
      a=a+1
      flaga=0
    }
    if((a+b)>=10){
      flaga=1
      c(g)=a+b-10
    }
    else{
      c(g)=a+b
    }
    i=i-1
    j=j-1
  }while(i>=(0-1) || j>=(0-1))
  do{
    print(c(g))
    g=g-1
  }while(g>0)
}