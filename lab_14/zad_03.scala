import akka.actor.{ActorSystem, Actor, ActorRef, Props}

object Nadzorca {
  case class Wynik(liczba1: Double, liczba2: Double)
  case object Zmien
}

class Pracownik extends Actor {
  import Nadzorca._
  def receive: Receive = {
    dodaj
  }
  def dodaj: Receive = {
    case Zmien => {
      context.become(mnoz)
    }
    case Wynik(liczba1, liczba2) => {
      println(liczba1 + liczba2)
    }
  }
  def mnoz: Receive = {
    case Zmien => {
      context.become(dodaj)
    }
    case Wynik(liczba1, liczba2) => {
      println(liczba1 * liczba2)
    }
  }
}

object Main extends App {
  import Nadzorca._
  val system = ActorSystem("sys")
  val dana = system.actorOf(Props[Pracownik], "dana")
  val liczba1 = 13
  val liczba2 = 169
  dana ! Wynik(liczba1, liczba2)
  dana ! Zmien
  dana ! Wynik(liczba1, liczba2)
  dana ! Zmien
  dana ! Wynik(liczba1, liczba2)
}
