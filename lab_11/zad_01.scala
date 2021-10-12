import akka.actor.{ActorSystem, Actor, ActorRef, Props}

object Nadzorca {
  case object Ping
  case object Pong
  case class Graj(przeciwnik: ActorRef)
}

class Nadzorca extends Actor {
  import Nadzorca._
  def receive: Receive = {
    case Graj(przeciwnik) => {
      Thread.sleep(2000)
      println("3...")
      Thread.sleep(1000)
      println("2...")
      Thread.sleep(1000)
      println("1...")
      Thread.sleep(1000)
      println("START")
      przeciwnik ! Ping
    }
    case Ping => {
      Thread.sleep(200)
      println("Ping")
      sender() ! Pong
    }
    case Pong => {
      Thread.sleep(200)
      println("   Pong")
      sender() ! Ping
    } 
  }
}

object Main extends App {
  import Nadzorca._
  val system = ActorSystem("sys")
  val ping = system.actorOf(Props[Nadzorca], "Ping")
  val pong = system.actorOf(Props[Nadzorca], "Pong")
  ping ! Graj(pong)
}
