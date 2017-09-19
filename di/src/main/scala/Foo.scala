import scaldi.{Injectable, Injector}
import scaldi.Injectable._

class Bar {

  println("Init bar")

  def barMethod = "bar"

  def close() = {
    println("Destroy bar")
  }

}

class Foo(implicit inj: Injector) {

  val bar = inject[Bar]

  def fooMethod: String = {
    s"foo method call bar: ${bar.barMethod}"
  }

}
