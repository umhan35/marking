package name.hanzhao.ta.markingFileSystem

import scalax.file.Path
import scalax.file.ImplicitConversions.string2path

// A markingDir has student directories.

class MarkingDir(assignmentN: Int) extends AnyRef with StudentDirs {
  val markingDirPath: Path =
    s"/Users/zhao/Dropbox/comp2150/a$assignmentN/marking"

  def markingFiles: Iterable[MarkingFile] =
    studentDirs * MarkingFile.fileName map(new MarkingFile(_))
}

trait StudentDirs {
  val markingDirPath: Path

  def studentDirs = markingDirPath * "[A-Z]*, *" filter(_.isDirectory)

  def lastModifiedStudentDir = studentDirs.maxBy(_.lastModified)

  lazy val johnAndersonDir = markingDirPath / "_ Anderson, John"
}
