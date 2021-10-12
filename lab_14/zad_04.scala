import akka.actor.{ActorSystem, Actor, ActorRef, Props, Terminated}

object Nadzorca {
  case class Init(liczbaPracownikow: Int)
  case class Silnia(i: Int)
  case object Kontynuuj
  case object Rozwiaz
  case class Wynik(wynik: Double, nr: Double)
}

class Nadzorca extends Actor {
  import Nadzorca._
  import Main._
  def receive: Receive = {
    init
  } 
  def init: Receive = {
    case Init(liczbaPracownikow) => {
      val pracownicy = for {
	i <- 1 to liczbaPracownikow
        pracownik = context.actorOf(Props[Pracownik], s"pracownik${i}")
      } yield pracownik							//tworzymy liste pracownikow

	context.become(sterminowany(pracownicy.toSet))
	pracownicy.zipWithIndex.foreach {
		case (p, i) => 
			context.watch(p)
			p ! Silnia(liczbaPracownikow-i)
	}								//wysylamy kolejne liczby
		

    }
  def sterminowany(ps: Set[ActorRef]): Receive = {
    	case Terminated(p) =>	
		val prac = ps - p
		context.become(sterminowany(prac))
		if(prac.isEmpty) {
			println("Wszyscy zakonczyli prace")
		}
    }

  }
}

class Pracownik extends Actor {
  import Nadzorca._
  import Main._
  def receive: Receive = {
    case Silnia(n) => {
		val wyniki = for {
			i <- 1 to n
		} yield i
		val odp = wyniki.foldLeft(1)((a, b) => a*b)
		println(s"${self.path} - wynik to: "+odp)
		context.stop(self)
	}
  }
}

object Main extends App {
  import Nadzorca._
  val system = ActorSystem("sys")
  val nadzorca = system.actorOf(Props[Nadzorca], "nadzorca")
  val wartosc = 3
  nadzorca ! Init(wartosc)
}
