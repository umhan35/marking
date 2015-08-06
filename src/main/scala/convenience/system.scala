package convenience

object system {
  def exit = sys.exit()

  implicit class RichInt(n: Int) {
    def times(f: => Unit) {
      if (n > 0) {
        f
        (n-1).times(f)
      }
    }
  }
}
