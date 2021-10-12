package jp.lab13

case class Osoba(imie: String, nazwisko: String)
case class Ocena(nota1: Int, nota2: Int, nota3: Int)
case class Zawodnik(osoba: Osoba, ocena: Ocena)

object Main extends App {

  val zawodnicy = for {
    i <- 1 to 15
    osoba = Gen.osoba
    ocena = Gen.ocena
  } yield Zawodnik(osoba, ocena)

  zawodnicy.foreach{ z =>
    println(s"${z.osoba.imie} ${z.osoba.nazwisko} : ${z.ocena.nota1 + z.ocena.nota2 + z.ocena.nota3}")
  }

}

