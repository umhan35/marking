package name.hanzhao.ta.marksheet

import scalax.file.ImplicitConversions.string2path
import scalax.file.Path

import scala.sys.process.Process

private[marksheet] trait MarksheetPath {

  private val original: Path =
    "/Users/zhao/Dropbox/comp2150/marking/marksheet/comp2150_marksheet.original.xlsx"

  val path: Path =
    "/Users/zhao/Dropbox/comp2150/marking/marksheet/comp2150_marksheet.xlsx"

  def backup = original.copyTo(target=path, replaceExisting=true)

  // call Mac OS's `open` command
  def macOpen = Process("open " + path.path).run
}
