package pl.multiplex.models

object MovieCategory extends Enumeration {

  type MovieCategory = Value

  val ADVENTURE = Value("Adventure")
  val ACTION = Value("Action")
  val HORROR = Value("Horror")
  val COMEDY = Value("Comedy")
  val ROMANCE = Value("Romance")
  val DRAMA = Value("Drama")
  val FANTASY = Value("Fantasy")

}