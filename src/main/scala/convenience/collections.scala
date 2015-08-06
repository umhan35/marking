package convenience

object collections {

  implicit class RichIterator[+A](iterator: collection.Iterator[A]) {
    def first = iterator.next()
    def nth(n: Int) = {
      iterator.drop(n - 1).next()
    }
  }

  implicit class RichArray[T](array: Array[T]) {
    def first = array(0)
  }
}