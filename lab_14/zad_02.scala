import akka.actor.{ActorSystem, Actor, ActorRef, Props, Stash}

object Nadzorca {
  case class Odbierz(wiadomosc: String)
}

class Nadzorca extends Actor with Stash {
  import Nadzorca._
  def receive: Receive = {
    zbierz
  }
  def zbierz: Receive = {
    case Odbierz("zmien") => {
      unstashAll()
      context.become(wyswietl)
    }
    case Odbierz(wiadomosc) => {
      stash()
    }
  }
  def wyswietl: Receive = {
    case Odbierz("zmien") => {
      println("koniec")
    }
    case Odbierz(wiadomosc) => {
      println(s"Wczesniej bylo: <$wiadomosc>")
    }
  }
}

object Main extends App {
  import Nadzorca._
  val system = ActorSystem("sys")
  val wiadomosc = system.actorOf(Props[Nadzorca], "wiadomosc")
  wiadomosc ! Odbierz("Witaj :-)")
  wiadomosc ! Odbierz("Czesc :-)")
  wiadomosc ! Odbierz("Co tam? :-)")
  wiadomosc ! Odbierz("A nic :-)")
  wiadomosc ! Odbierz("No to fajnie :-)")
  wiadomosc ! Odbierz("zmien")
}
