package name.hanzhao.ta.assignment

import name.hanzhao.ta.markingFileSystem.MarkingFiles
import name.hanzhao.ta.marksheet.Marksheet
import name.hanzhao.ta.student.Student

import scalax.file.Path
import scalax.file.ImplicitConversions.string2path

abstract class Assignment(val assignmentN: Int, val submissions: Int) extends AnyRef
  with MarkingFilesTasks
  with MarkTasks
{
  lazy val markingFiles = new MarkingFiles(assignmentN)
  lazy val (students, marks) = markingFiles.read
}

trait MarkingFilesTasks {
  val assignmentN: Int
  val markingFiles: MarkingFiles

  private val markingCommentsDir: Path =
    s"/Users/zhao/Dropbox/comp2150/a$assignmentN/marking_comments"

  def copyMarkingFiles = markingFiles copyTo markingCommentsDir.path
}

trait MarkTasks {
  val assignmentN: Int
  val students: TraversableOnce[Student]

//  def addMarksToMarksheet = Marksheet.addMarks(assignmentN, students)
  def `add marks to marksheet` = Marksheet.addMarks(assignmentN, students)
}
