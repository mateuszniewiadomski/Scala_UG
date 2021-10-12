import akka.actor.{ActorSystem, Actor, ActorRef, Props}

object Nadzorca {
  case class Odbierz(wiadomosc: String)
  case object Wyswietl
}

class Nadzorca extends Actor {
  import Nadzorca._
  def receive: Receive = {
    odbierz
  }
  def odbierz: Receive = {
    case Odbierz(wiadomosc) => {
      context.become(wyswietl(wiadomosc))
    }
  }
  def wyswietl(wiadomosc: String): Receive = {
    case Wyswietl => {
      println(s"$wiadomosc")
    }
  }
}

object Main extends App {
  import Nadzorca._
  val system = ActorSystem("sys")
  val wiadomosc = system.actorOf(Props[Nadzorca], "wiadomosc")
  val tresc = "Czesc!"
  wiadomosc ! Odbierz(tresc)
  wiadomosc ! Wyswietl
}
