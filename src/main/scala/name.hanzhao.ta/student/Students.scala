package name.hanzhao.ta.student

class Students(students: Iterable[Student]) {
  def filterMark(p: Float => Boolean) =
    students.filter(s => p(s.mark))

  def printWithIndex = {
    students.zipWithIndex.foreach {
      case (student, i) => println(s"${i+1}: $student")
    }
  }

  def assigningSummary(totalStudents: Int) = {
    s"${totalStudents - students.size} remaining"
  }
}

object Students {
  implicit class RichStudents(students: Iterable[Student])
    extends Students(students)
}