import java.util.concurrent.locks.ReentrantReadWriteLock

import scala.concurrent.duration.Duration
import scala.concurrent.{Await, Future}
import scala.concurrent.ExecutionContext.Implicits.global

class Counter {

  private var count = 0

  private val readWriteLock = new ReentrantReadWriteLock()

  def inc(): Unit = {
    readWriteLock.writeLock().lock()
    try {
      count += 1
      Thread.sleep(3000)
    } finally {
      readWriteLock.writeLock().unlock()
    }
  }

  def getCount: Int = {
    readWriteLock.readLock().lock()
    try {
      count
    } finally {
      readWriteLock.readLock().unlock()
    }
  }

}

class CounterWithLock {
  wait()
}

object CounterApp extends App {

  val c = new Counter()

//  val f: Future[immutable.Seq[Unit]] = Future.sequence {
//    (1 to 5).map(_ => {
//      Future { c.inc() }
//    })
//  }

  val f = Future.sequence {
    Seq(Future { c.inc() }, Future { Thread.sleep(1000); println(s"current count is ${c.getCount}") })
  }

  Await.ready(f, Duration.Inf)

}
