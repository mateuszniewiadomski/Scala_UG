import akka.actor.{ActorSystem, Actor, ActorRef, Props, Terminated}

object Nadzorca {
  case class Init(liczbaPracownikow: Int)
  case class Zlecenie(tekst: List[String])
  case class Wykonaj(tekst: String)
  case class Wynik(wynik: Int)
}

class Nadzorca extends Actor {
  import Nadzorca._
  def receive: Receive = {
    case Init(liczbaPracownikow) => {
      def createWorkers(pracownicy: Set[ActorRef], liczba: Int): Seq[ActorRef] = {
        (liczba) match {
          case 0 => pracownicy.toSeq
          case _ => {
            val pracownik = context.actorOf(Props[Pracownik], "#"+(pracownicy.size)+"pracownik")
            context.watch(pracownik)
            createWorkers(pracownicy + pracownik, liczba - 1)
          }
        }
      }    
      context.become(getOrder(createWorkers(Set.empty, liczbaPracownikow)))
    }
  }
  def getOrder(pracownicy: Seq[ActorRef]): Receive = {
    case Zlecenie(tekst) => {
      println(tekst.flatMap(_.split("\n")))
      context.become(getResult(pracownicy.toSet, sendOrder(pracownicy, tekst.flatMap(_.split("\n"))), 0))
      def sendOrder(pracownicy: Seq[ActorRef], tekst: List[String]): List[String] = {
        (pracownicy, tekst) match {
          case (Seq(), tekst) => tekst
          case (p1 +: pn, t1 +: tn) => {
            p1 ! Wykonaj(t1)
            sendOrder(pn, tn)
          }    
        }
      }
    }
  }
  def getResult(pracownicy: Set[ActorRef], tekst: List[String], wynik: Int): Receive = {
    case Wynik(liczbaPracownikow) => {
      (tekst) match {
        case List() => {
          context.stop(sender())
          context.become(getResult(pracownicy, tekst, wynik + liczbaPracownikow))
        }
        case (t1 +: tn) => {
          sender() ! Wykonaj(t1)
          context.become(getResult(pracownicy, tn, wynik + liczbaPracownikow))
        }
      }
    }
    case Terminated(pracownik) => {
      if((pracownicy-pracownik).isEmpty) {
        println(s"Ilosc slow $wynik")
        context.become(getOrder(pracownicy.toSeq))
      }
      context.become(getResult(pracownicy-pracownik, tekst, wynik))
    }
  }
}

class Pracownik extends Actor {
  import Nadzorca._
  def receive: Receive = {
    case Wykonaj(tekst) => {
      sender() ! Wynik(tekst.split(" ").count(_!=""))
    }
  }
}

object Main extends App {
  import Nadzorca._
  def dane(): List[String] = {
    scala.io.Source.fromResource("ogniem_i_mieczem.txt").getLines.toList
  }
  val system = ActorSystem("sys")
  val nadzorca = system.actorOf(Props[Nadzorca], "Nadzorca")
  val liczbaPracownikow = 10
  nadzorca ! Init(liczbaPracownikow)
  nadzorca ! Zlecenie(dane())
}
