package jp.aktorzy.primes

import akka.actor.{Actor, ActorRef, ActorSystem, Props, Stash}

object Nadzorca {
  case class Zadanie(n: Int)
  case class Komunikat(n: Int)
  case object WynikProszę
  case class Wynik(pierwsze: Seq[Int])
}

class Szef extends Actor {

  import Nadzorca._

  def receive = czekamyNaZadanie

  def czekamyNaZadanie: Receive = {
    case Zadanie(n) =>
      val pracownik = context.actorOf(Props[Pracownik], "pracownik")
      for (k <- 2 to n) {
        pracownik ! Komunikat(k)
      }
      pracownik ! WynikProszę
      context.become(czekamyNaWynik)
  }

  def czekamyNaWynik: Receive = {
    case Wynik(pierwsze) =>
      println(s"liczby pierwsze: $pierwsze")
      context.become(czekamyNaZadanie)
  }

}

class Pracownik extends Actor {

  import Nadzorca._

  def receive: Receive = {
    case Komunikat(n) =>
      context.become(zeSkarbem(n))
  }

  def zeSkarbem(skarb: Int): Receive = {
    case msg @ Komunikat(n) if n % skarb != 0 =>
      val podwykonawca = context.actorOf(Props[Pracownik], s"skarb$skarb")
      podwykonawca ! msg
      context.become(zeSkarbemIPotomkiem(skarb, podwykonawca))
    case WynikProszę =>
      context.parent ! Wynik(Seq(skarb))
  }

  def zeSkarbemIPotomkiem(skarb: Int, potomek: ActorRef): Receive = {
    case msg @ Komunikat(n) if n % skarb != 0 =>
      potomek ! msg
    case msg @ WynikProszę =>
      potomek ! msg
      context.become(czekającNaWynik(skarb))
  }

  def czekającNaWynik(skarb: Int): Receive = {
    case Wynik(liczby) =>
      context.parent ! Wynik(skarb +: liczby)
  }

}

object Primes extends App {
  import Nadzorca._
  val system = ActorSystem("NaszSystem")
  val szef = system.actorOf(Props[Szef], "szef")
  val szef2 = system.actorOf(Props[Szef], "szef2")
  val szef3 = system.actorOf(Props[Szef], "szef3")
  szef ! Zadanie(127)
  szef2 ! Zadanie(256)
  szef3 ! Zadanie(25)
}