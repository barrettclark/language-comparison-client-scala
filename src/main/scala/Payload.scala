package client

import argonaut._, Argonaut._
case class Payload(name: String, pi: Double, theBestNumber: Int, rightNow: String)

object Payload {
  val Default = new Payload("default name", 1.23, 0, "default datetime")

  implicit def decodeJson: DecodeJson[Payload] = { DecodeJson(h => for {
    name          <- (h --\ "name").as[String]
    pi            <- (h --\ "pi").as[Double]
    theBestNumber <- (h --\ "best_number").as[Int]
    rightNow      <- (h --\ "right_now").as[String]
  } yield new Payload(name, pi, theBestNumber, rightNow))
  }
}
