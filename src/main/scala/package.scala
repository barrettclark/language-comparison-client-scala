import argonaut._, Argonaut._
import com.github.nscala_time.time.Imports._

package object client {
  implicit def decodeDateTimeJson: DecodeJson[DateTime] = { DecodeJson(h => for {
      string    <- h.as[String]
    } yield DateTime.parse(string))
  }
}
