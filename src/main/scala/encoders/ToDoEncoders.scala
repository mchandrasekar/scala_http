package encoders

import io.circe.Encoder
import io.circe.syntax.EncoderOps
import todo.Todo
import scala.collection.mutable.ListBuffer
import io.circe.Json

trait ToDoEncoders {
  implicit val todoEncoder = Encoder.instance[Todo] { h =>
    Json.obj(
      "name" -> Json.fromString(h.title),
      "id" -> Json.fromBoolean(h.completed),
      "order" -> Json.fromInt(h.order)
    )
  }
  implicit val todoEncoderList = Encoder.instance[List[Todo]] { h =>
    h.asJson
  }
}
