package name.hanzhao.ta.mark

object Marks {
  implicit class RichMarks(val marks: Iterable[Mark]) extends AnyRef
    with MarksStats
    with AverageSummary
}

trait AverageSummary {
  val average: Float

  def averageWithTotal = f"$average%.2f/${Mark.total}"
  def averageSummary = "Average: " + averageWithTotal
}

trait MarksStats {
  protected val marks: Iterable[Mark]

  lazy val sum = marks.map(_.value).sum
  lazy val total = marks.size
  lazy val average = sum / total
}
