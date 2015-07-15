package client

import argonaut._, Argonaut._
import com.twitter.finagle.httpx
import com.twitter.finagle.{Httpx, Service}
import com.twitter.util.{Await,Future}
import scalaz._

// The HTTP Client
object Client extends App {
  import Util._
  
  for (i <- 1 to 100) {
    val payload = getPayload()
    val _ = Await.ready(payload)
    println(payload)
  }

  def getPayload(): Future[Payload] = {
    val client = Httpx.Client().newService("localhost:9292")
    val request = httpx.Request(httpx.Method.Get, "/")
    client(request) flatMap { resp =>
      bufToString(resp.content).decodeEither[Payload] match {
        case -\/ (l) => println(l); Future.value(Payload.Default)
        case \/- (r) => Future.value(r)
      }
    }
  }
}
