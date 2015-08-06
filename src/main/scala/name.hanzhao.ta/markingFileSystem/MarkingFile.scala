package name.hanzhao.ta.markingFileSystem

import scala.util.Try
import scalax.file.Path

import name.hanzhao.ta.student.Student

// Marking files, named _marking.md, are under student directories.

object MarkingFile {
  val fileName = "_marking.md"
}

class MarkingFile(val path: Path) {
  lazy val mark: Float =
    (for {
      markingLine <- Try(path.lines().apply(1))
        .recoverWith({ case e => println("Doesn't have 2nd line."); throw e })
      mark <- Try(markingLine.split('/').head.toFloat)
        .recoverWith({ case e => println("Failed to get mark in float."); throw e })
    } yield mark)
      .getOrElse(Float.NaN)

  lazy val studentName: String =
    path.parent.map(_.simpleName).getOrElse("N/A")

  lazy val student = Student(studentName, mark)
}
