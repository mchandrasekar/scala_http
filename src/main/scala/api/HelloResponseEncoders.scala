package api

import io.circe.Encoder
import io.circe.syntax.EncoderOps

trait HelloResponseEncoders {
  implicit val helloEncoder = Encoder.instance[Hello] { h =>
    Map("hello" -> Map("name" -> h.name)).asJson
  }
}
