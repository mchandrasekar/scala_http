import com.twitter.finagle.Service
import com.twitter.finagle.http.{Request, Response}

import api.v1.hello.HelloApi
import encoders.ResponseEncoders
import io.finch.circe.encodeCirce

object ApiService extends ResponseEncoders {
  private def api = HelloApi.helloApi
  def apiService: Service[Request, Response] = (api).toService
}
