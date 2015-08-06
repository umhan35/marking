package name.hanzhao.ta.markingFileSystem

import scalax.file.ImplicitConversions.string2path
import scalax.file.Path

import name.hanzhao.ta.mark.Mark
import name.hanzhao.ta.student.Student

// Operations on marking files
class MarkingFiles(assignmentN: Int) {

  lazy val all = new MarkingDir(assignmentN).markingFiles

  // read students and marks
  def read: (Iterable[Student], Iterable[Mark]) = {
    val students = all.map(_.student).toSeq.sortBy(_.name)
    val marks = students.map(Mark.fromStudent)
    (students, marks)
  }

  // copy to a directory: used to zip all marking fils and email to instructor
  def copyTo(dir: String) {
    all.foreach(markingFile => {
      val toPath: Path = dir + "/" + markingFile.studentName + ".md"
      markingFile.path.copyTo(toPath)
    })
  }
}
