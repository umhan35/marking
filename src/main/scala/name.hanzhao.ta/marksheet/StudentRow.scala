package name.hanzhao.ta.marksheet

import org.apache.poi.ss.usermodel.Row

class StudentRow(row: Row) {
  def addMark(assignmentN: Int, mark: Float) {
    row.createCell(2 + assignmentN).setCellValue(mark)
  }
}
