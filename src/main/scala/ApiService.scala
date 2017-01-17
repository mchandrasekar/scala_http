import com.twitter.finagle.Service
import com.twitter.finagle.http.{Request, Response}
import api.v1.hello._
import io.finch._

object ApiService {
  private def api = HelloApi.helloApi
  def apiService: Service[Request, Response] = (api).toServiceAs[Text.Plain]
}
