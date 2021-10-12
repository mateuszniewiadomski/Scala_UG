package jp.lab13

sealed trait Płeć
case object M extends Płeć
case object K extends Płeć

object Gen {
  import scala.io.Source
  import scala.util.Random
  private val rand = new Random
  val im: Seq[String] = Source.fromFile("imiona-meskie.csv").getLines.toList
  val iz: Seq[String] = Source.fromFile("imiona-zenskie.csv").getLines.toList
  val nm: Seq[String] = Source.fromFile("nazwiska-meskie.csv").getLines.toList
  val nz: Seq[String] = Source.fromFile("nazwiska-zenskie.csv").getLines.toList

  def osoba: Osoba = {
    val x = math.random
    val imie = {
      if(x < 0.51) im((math.random * (10000) + 1).toInt).filter(a => a.isLetter)
      else iz((math.random * (10000) + 1).toInt).filter(a => a.isLetter)
    }
    val nazwisko = {
      if(x < 0.51) nm((math.random * (10000) + 1).toInt).filter(a => a.isLetter)
      else nz((math.random * (10000) + 1).toInt).filter(a => a.isLetter)
    } 
    new Osoba(imie, nazwisko)
  }
  def ocena: Ocena = {
    val nota1 = (math.random * (10) + 1).toInt
    val nota2 = (math.random * (10) + 1).toInt
    val nota3 = (math.random * (10) + 1).toInt
    new Ocena(nota1, nota2, nota3)
  }
}
