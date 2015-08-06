package name.hanzhao.ta.assignment

import name.hanzhao.ta.mark.Marks.RichMarks
import name.hanzhao.ta.student.Students.RichStudents

class CommonAssignment(override val assignmentN: Int,
                       override val submissions: Int)
  extends Assignment(assignmentN, submissions) {

  def main {

    students
//      .filterMark(_ > 90)
      .printWithIndex
    println
    println(marks.averageSummary)
    println
    println(students.assigningSummary(submissions))
    println
  }
}
