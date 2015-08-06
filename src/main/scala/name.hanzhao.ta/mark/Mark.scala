package name.hanzhao.ta.mark

import name.hanzhao.ta.student.Student

case class Mark(student: Student, value: Float)

object Mark {
  val total = 100
  def fromStudent(s: Student) = Mark(s, s.mark)
}
