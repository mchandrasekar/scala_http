package api.v1.hello

import com.twitter.finagle.{ Http }
import io.finch.{ Endpoint, _ }

object HelloApi {
  def helloApi() = get_hello :+: post_hello

  def get_hello: Endpoint[String] =
    get("v1" :: "hello" :: string("name")) { (name: String) =>
      Ok("Hello Worlk")
    }
  
  def post_hello: Endpoint[String] = post(string :: string) { (a: String, b: String) =>
    Ok(a + b)
  } handle {
    case e: ArithmeticException => BadRequest(e)
  }
}
