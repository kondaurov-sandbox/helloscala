import scaldi.{Module, TypesafeConfigInjector}

object Main extends App {

  implicit val module = new AppModule()

  module.initNonLazy()

  io.StdIn.readLine()

  println(new Foo().fooMethod)

  module.destroy()

  TypesafeConfigInjector

}

class AppModule extends Module {

  bind[Bar] to new Bar() destroyWith(_.close())

}
