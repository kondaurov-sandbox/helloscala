import java.util.concurrent.Executors

import scala.collection.mutable
import scala.concurrent.Future

import scala.concurrent.ExecutionContext.Implicits.global

class Foo {

  val s = mutable.Map.empty[String, Char]

  def add() = {
    println("a_start")
    Thread.sleep(3000)
    print("a")
  }

  def check() = {
    print("c")
  }

}

object App extends App {


  val foo = new Foo()

  Future { foo.add() }

  Thread.sleep(1000)

  Future { foo.check() }

}
