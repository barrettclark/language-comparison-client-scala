package client

import argonaut._, Argonaut._
import com.twitter.finagle.{Httpx, Service}
import com.twitter.finagle.httpx
import com.twitter.util.{Await,Future}
import scalaz._

// The HTTP Client
object Client extends App {
  import Util._

  def getPayload(): Future[Payload] = {
    val client = new Httpx.Client().newService("localhost:9292")
    val request = httpx.Request(httpx.Method.Get, "/")
    client(request) flatMap { resp =>
      bufToString(resp.content).decodeEither[Payload] match {
        case -\/ (l) => println(l); Future.value(Payload.Default)
        case \/- (r) => Future.value(r)
      }
    }
  }

  val payload = getPayload()
  Await.ready(payload)
  println(payload)
}
