import name.hanzhao.ta.markingFileSystem.MarkingDir

object PrepareMarking {

  val markingDir = new MarkingDir(assignmentN = 5)

  //  val fileNamesToCopy = Seq("input.txt", "_marking.md") // a4
  val fileNamesToCopy = Seq("_marking.md") // a5

  def main(args: Array[String]) {
    import markingDir.{johnAndersonDir, lastModifiedStudentDir}

    println("lastModifiedStudentDir: " + lastModifiedStudentDir.path)
    fileNamesToCopy.foreach(fileName => {
      print(s"Copying $fileName")
      try { (johnAndersonDir / fileName).copyTo(lastModifiedStudentDir / fileName) }
      catch { case e: java.io.IOException => print(s"\t$e") }
      println
    })
  }
}