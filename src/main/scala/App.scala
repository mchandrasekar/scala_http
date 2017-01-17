import com.twitter.finagle.Http
import com.twitter.finagle.ListeningServer
import com.twitter.util.Await

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
