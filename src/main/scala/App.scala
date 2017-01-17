import com.twitter.finagle.param.Stats
import com.twitter.finagle.{Http, ListeningServer}
import com.twitter.util.Await
import io.finch._
import cats.instances.int._

final class App {
  lazy val server: ListeningServer = Http.server
    .serve(":8080", ApiService.apiService)

  def boot(): Unit = {
    Await.ready(server)
  }

  private def shutdown(): Unit = {
    Await.ready(server.close())
  }

}

object App {
  def main(args: Array[String]): Unit = {
    new App().boot()
  }
}
