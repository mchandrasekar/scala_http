package api.v1.hello

import java.util.UUID

import api.Hello
import io.circe.generic.auto._
import io.finch._
import io.finch.BadRequest
import io.finch.Endpoint
import io.finch.circe._
import todo.Todo

object HelloApi {
  def helloApi() = get_hello :+: post_hello :+: get_hello_object :+: get_hello_error :+: getTodos :+: postTodo
  def get_hello: Endpoint[String] =
    get("v1" :: "hello" :: string("name")) { (name: String) =>
      Ok("Hello Worlk")
    }

  def post_hello: Endpoint[Int] = post(int :: int) { (a: Int, b: Int) =>
    Ok(a / b)
  } handle {
    case e: ArithmeticException => BadRequest(e)
  }

  def get_hello_object: Endpoint[Hello] =
    get("v1" :: "hello1" :: string("name")) { (name: String) =>
      Ok(Hello(name))
    }

  def get_hello_error: Endpoint[Hello] =
    get("v1" :: "hello2" :: string) { (name: String) =>
      if (name == "success") Ok(Hello(name))
      else BadRequest(new IllegalArgumentException("empty string"))
    }
  
  def getTodos: Endpoint[List[Todo]] = get("todos") {
    Ok(Todo.list())
  }

  def postTodo: Endpoint[Todo] = post("todos" :: postedTodo) { t: Todo =>
    Todo.save(t)
    Created(t)
  }
  
  def postedTodo: Endpoint[Todo] = jsonBody[UUID => Todo].map(_(UUID.randomUUID()))
}


