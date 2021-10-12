import akka.actor.{ActorSystem, Actor, ActorRef, Props}

object Nadzorca {
  case class Wyslij(a: Double, b: Double, c: Double, serwer: ActorRef)
  case class Sprawdz(a: Double, b: Double, c: Double)
}
class Klient extends Actor {
  import Nadzorca._
  def receive: Receive = {
    case Wyslij(a, b, c, serwer) => {
      serwer ! Sprawdz(a, b, c)
    }
    case true => {
      println(true)
    }
    case false => {
      println(false)
    }
  }
}
class Serwer extends Actor {
  import Nadzorca._
  def receive: Receive = {
    case Sprawdz(a, b, c) if ((a + b > c) && (a + c > b) && (b + c > a)) => sender() ! true
    case Sprawdz(a, b, c) if !((a + b > c) && (a + c > b) && (b + c > a)) => sender() ! false
  }
}
object Main extends App {
  import Nadzorca._
  val system = ActorSystem("sys")
  val klient = system.actorOf(Props[Klient], "klient")
  val serwer = system.actorOf(Props[Serwer], "serwer")
  klient ! Wyslij(3, 4, 5, serwer)
  klient ! Wyslij(1, 2, 2, serwer)
  klient ! Wyslij(1, 10, 20, serwer)

}
