import java.util.concurrent.Executors

import scala.collection.mutable
import scala.concurrent.{ExecutionContext, Future}

class Foo {

  val s = mutable.Map.empty[String, Char]

  def add(key: String, value: Char): Future[Unit] = synchronized {
    Future {
      s(key) = value
    }
  }

  def remove(key: String): Future[Unit] = Future {
    s.remove(key)
  }

  def get(key: String): Option[Char] = {
    s.get(key)
  }

}

object App extends App {

  implicit val ec = ExecutionContext.fromExecutor(Executors.newCachedThreadPool())

  val foo = new Foo()




  println("app")

}
