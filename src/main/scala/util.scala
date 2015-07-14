package client

import com.twitter.io.Buf
import com.twitter.io.Buf.Utf8

object Util {
  val bufToString = (buf: Buf) => Utf8.unapply(buf) match {
    case Some(x) => x
    case None    => ""
  }
}
