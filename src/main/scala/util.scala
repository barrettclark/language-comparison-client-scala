package client

import com.twitter.io.Buf
import com.twitter.io.Buf.Utf8

object Util {
  def bufToString(buf: Buf): String = Utf8.unapply(buf) match {
    case Some(x) => x
    case None    => ""
  }
}
