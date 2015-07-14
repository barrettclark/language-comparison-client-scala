package client

import argonaut._, Argonaut._
import com.github.nscala_time.time.Imports._

case class Payload(name: String, pi: Double, theBestNumber: Int, rightNow: DateTime)

object Payload {
  val Default = new Payload("default name", 1.23, 0, DateTime.now)

  implicit def decodeJson: DecodeJson[Payload] = { DecodeJson(h => for {
      name          <- (h --\ "name").as[String]
      pi            <- (h --\ "pi").as[Double]
      theBestNumber <- (h --\ "best_number").as[Int]
      rightNow      <- (h --\ "right_now").as[DateTime]
    } yield new Payload(name, pi, theBestNumber, rightNow))
  }
}
