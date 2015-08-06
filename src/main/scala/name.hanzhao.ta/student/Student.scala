package name.hanzhao.ta.student

case class Student(name: String, mark: Float) {
  override def toString = s"$name: $mark"
}