package encoders

import com.twitter.finagle.http.Message._
import com.twitter.io.Buf._
import io.circe.Encoder
import io.circe.syntax._

trait ErrorResponseEncoders {
  implicit val exceptionEncoder = Encoder.instance[Exception] { e =>
    val base = Map(
      "message" -> e.getMessage,
      "type" -> e.getClass.getSimpleName
    )
    val withCause = base.++(Option(e.getCause).map(cause => Map("cause" -> cause.getMessage)).getOrElse(Map()))
    withCause.asJson
  }
}
