

object App2 extends App {

class Foo {
  override def finalize(): Unit = {
    println("destructing foo")
  }
}

  println("test auto closing methods")

  val f = new Foo()

}
