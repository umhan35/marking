package name.hanzhao.ta.marksheet

import scala.collection.JavaConversions._

import org.apache.poi.ss.usermodel.Cell
import org.apache.poi.xssf.usermodel.XSSFWorkbook

import name.hanzhao.ta.student.Student

class Marksheet {
  val workbook = new XSSFWorkbook(Marksheet.path.inputStream.open.get)

  def findStudentRow(studentName: String): Option[StudentRow] = {
    val worksheet = workbook.getSheetAt(0)

    worksheet.find(row => {
      val nameCell = row.getCell(1)
      nameCell != null &&
        nameCell.getCellType == Cell.CELL_TYPE_STRING &&
        nameCell.getStringCellValue.trim.contains(studentName)
    })
    .map(new StudentRow(_))
  }

  def write {
    workbook.write(Marksheet.path.outputStream().open.get)
  }
}

object Marksheet extends MarksheetPath {

  def modify(f: Marksheet => Unit) {
    backup

    val marksheet = new Marksheet
    f(marksheet)
    marksheet.write
  }

  def addMarks(assignmentN: Int, students: TraversableOnce[Student]) {
    modify { marksheet =>
      students.foreach { student =>
        marksheet
          .findStudentRow(student.name).get
          .addMark(assignmentN, student.mark)
      }
    }
  }
}